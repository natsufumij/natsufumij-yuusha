package natsufumij.common.limit;

import com.fasterxml.jackson.databind.ObjectMapper;
import hut.natsufumij.common.limit.LimitRequest;
import hut.natsufumij.common.resp.V;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 代码层面上的请求降级
 */
@AllArgsConstructor
public class LimitRequestHandler implements HandlerInterceptor {

    private final StringRedisTemplate stringRedisTemplate;
    private static final String REDIS_KEY_PREF = "REQUEST:LIMIT:";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod han) {
            hut.natsufumij.common.limit.LimitRequest methodLimit = han.getMethodAnnotation(hut.natsufumij.common.limit.LimitRequest.class);
            hut.natsufumij.common.limit.LimitRequest controllerLimit = han.getBean().getClass().getAnnotation(hut.natsufumij.common.limit.LimitRequest.class);
            LimitRequest result = methodLimit != null ? methodLimit : controllerLimit;
            if (result == null || result.pass()) {
                return true;
            }

            int seconds = result.seconds();
            int counts = result.counts();
            String remoteAdder = request.getRemoteAddr();
            remoteAdder = remoteAdder.replaceAll(":", "_");
            remoteAdder = remoteAdder.replaceAll("\\.", "-");
            String realKey = REDIS_KEY_PREF + remoteAdder + ":" + request.getRequestURI();
            String countStr = stringRedisTemplate.opsForValue().get(realKey);
            int co;
            if (countStr == null) {
                co = 0;
            } else {
                try {
                    co = Integer.parseInt(countStr);
                } catch (NumberFormatException e) {
                    co = 0;
                }
            }
            if (co == 0) {
                stringRedisTemplate.opsForValue().set(realKey, "1", seconds, TimeUnit.SECONDS);
            } else {
                ++co;
                if (co > counts) {
                    render(response);
                    return false;
                } else {
                    stringRedisTemplate.opsForValue().set(realKey, co + "");
                }
            }
            return true;
        }

        return true;
    }

    private void render(HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        V<Void> rv = V.buildError(400,502, "接口请求次数过多!");
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(rv);
        out.write(str.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }
}
