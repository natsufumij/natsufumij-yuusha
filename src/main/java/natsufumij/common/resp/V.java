package natsufumij.common.resp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hut.natsufumij.common.resp.PageV;
import hut.natsufumij.common.resp.YuushaExceptionEnum;
import lombok.Getter;

import java.util.List;

@Getter
public class V <T>{
    public static <T> V<T> yes(T t){
        return new V<>(t);
    }
    public static <T> V<T> yes(List<T> t){
        Page<T> p = new Page<>();
        p.setRecords(t);
        p.setCurrent(1);
        p.setSize(t.size());
        return new V<>(p);
    }

    public static <T> V<T> yes(IPage<T> t){
        return new V<>(t);
    }
    public static V<Void> yes(){
        return new V<>();
    }
    public static void no(int hCode, YuushaExceptionEnum ex){
        throw new YuushaException(hCode,ex.code(),ex.msg());
    }
    public static V<Void> buildError(int hCode,int code,String msg){
        return new V<>(hCode,code,msg);
    }

    // response success
    private final boolean success;
    // response data
    private final T data;
    // response page
    private final PageV<T> page;

    // http Code
    private final int hCode;
    // code
    private final int code;
    // message
    private final String msg;

    private V(){
        this.data=null;
        this.page=null;
        this.success=true;
        this.hCode=200;
        this.code=0;
        this.msg="OK";
    }
    private V(T t){
        this.data=t;
        this.page=null;
        this.success=true;
        this.hCode=200;
        this.code=0;
        this.msg="OK";
    }
    private V(IPage<T> t){
        this.data=null;
        this.page= new PageV<>(t);
        this.success=true;
        this.hCode=200;
        this.code=0;
        this.msg="OK";
    }
    private V(int hCode,int code,String msg){
        this.hCode=hCode;
        this.code=code;
        this.msg=msg;
        this.data=null;
        this.page=null;
        this.success=false;
    }
}
