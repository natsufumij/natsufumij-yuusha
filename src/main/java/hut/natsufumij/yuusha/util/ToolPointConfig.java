package hut.natsufumij.yuusha.util;

import hut.natsufumij.yuusha.util.config.MyWebConfig;
import hut.natsufumij.yuusha.util.limit.LimitRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@Import(MyWebConfig.class)
@EnableSwagger2WebMvc
public class ToolPointConfig {
    public static void main(String[] args) {

    }

    @Bean
    public LimitRequestHandler limitRequestHandler(StringRedisTemplate stringRedisTemplate){
        return new LimitRequestHandler(stringRedisTemplate);
    }
}
