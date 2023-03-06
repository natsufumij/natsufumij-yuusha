package hut.natsufumij.yuusha.util.bean;

import org.springframework.beans.BeanUtils;

public class Beans {
    public interface FGenerator<F> {
        F generate();
    }
    public interface plusOne<T>{
        int add(T t);
    }

    public static <T, F> F convert(T t,FGenerator<F> f){
        F ff = f.generate();
        BeanUtils.copyProperties(t,ff);
        return ff;
    }

    public static <T,F> F mapAddOne(plusOne<F> plusOne, T source, FGenerator<F> f){
        F ff = convert(source,f);
        plusOne.add(ff);
        return ff;
    }
}
