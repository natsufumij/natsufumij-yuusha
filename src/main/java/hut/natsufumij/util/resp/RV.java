package hut.natsufumij.util.resp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import hut.natsufumij.util.exception.ExceptionEnum;
import hut.natsufumij.util.exception.YuushaException;
import lombok.Getter;

import java.util.List;

@Getter
public class RV<T> {
    private final T data;
    private final List<T> pageList;
    private final PageInfo<T> pageInfo;
    private final Integer code;
    private final String msg;

    private RV(T data) {
        this.data = data;
        pageList = null;
        pageInfo = null;
        code = 200;
        msg = "";
    }

    private RV(List<T> page) {
        this.data = null;
        this.pageList = page;
        if (page instanceof Page<T> p) {
            this.pageInfo = p.toPageInfo();
            this.pageInfo.setList(null);
        } else {
            this.pageInfo = null;
        }
        code = 200;
        msg = "";
    }

    private RV(int code, String msg) {
        this.data = null;
        this.pageList = null;
        this.pageInfo = null;
        this.msg = msg;
        this.code = code;
    }

    public static <T> RV<Boolean> of(boolean bool){
        return new RV<>(bool);
    }
    public static <T> RV<T> of(T t) {
        return new RV<>(t);
    }
    public static <T> RV<T> of(List<T> t){
        return new RV<>(t);
    }
    public static RV<Void> of(){
        return new RV<>(null);
    }
    public static void error(ExceptionEnum en){
        throw new YuushaException(en.code(),en.msg());
    }
    public static <T> RV<T> buildError(int code,String msg){
        return new RV<>(code,msg);
    }
}
