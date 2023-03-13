package natsufumij.common.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitRequest {
    int seconds() default 5;
    int counts() default 1;
    boolean pass() default false;
    boolean login() default false;
}
