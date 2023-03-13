package natsufumij.common.bean;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pageInter = new PaginationInnerInterceptor();
        pageInter.setOptimizeJoin(true);
        pageInter.setDbType(DbType.MYSQL);
        pageInter.setOverflow(true);
        interceptor.addInnerInterceptor(pageInter);
        OptimisticLockerInnerInterceptor opt = new OptimisticLockerInnerInterceptor();
        interceptor.addInnerInterceptor(opt);
        return interceptor;
    }
}
