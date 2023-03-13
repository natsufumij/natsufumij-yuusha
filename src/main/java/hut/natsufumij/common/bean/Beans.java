package hut.natsufumij.common.bean;

import org.springframework.beans.BeanUtils;

public class Beans {
    public interface FGenerator<F> {
        F generate();
    }
    public static <T, F> F convert(T t,FGenerator<F> f){
        F ff = f.generate();
        BeanUtils.copyProperties(t,ff);
        return ff;
    }
}
