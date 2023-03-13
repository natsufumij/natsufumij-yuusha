package hut.natsufumij.common;

import hut.natsufumij.common.limit.LimitRequestHandler;
import hut.natsufumij.common.resp.MyWebConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
@Import(MyWebConfig.class)
public class ToolPointConfig {
    public static void main(String[] args) {
    }

    @Bean
    public LimitRequestHandler limitRequestHandler(StringRedisTemplate stringRedisTemplate){
        return new LimitRequestHandler(stringRedisTemplate);
    }
}
