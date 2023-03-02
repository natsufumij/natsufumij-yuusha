package old;


import old.Page;
import java.util.List;

public record RV<T>(int hCode, int code, String msg, T data, Page<T> page) {

    public static RV<Void> of(int code, String msg) {
        return of(400, code, msg);
    }

    public static RV<Void> of(int hCode, int code, String msg) {
        return new RV<>(hCode, code, msg, null, null);
    }

    public static <T> RV<T> of(T t) {
        return new RV<>(200, 0, "OK", t, null);
    }

    public static <T> RV<T> of(Page<T> t) {
        return new RV<>(200, 0, "OK", null, t);
    }

    public static <T> RV<T> of(List<T> t) {
        RV<T> d = new RV<>(200, 0, "OK", null, new Page<>(1, t.size()));
        d.page.setItems(t);
        d.page.setTotal(t.size());
        d.page.calcTotalPage();
        return d;
    }

    public static void error(int code,String msg){
        throw new RVException(msg,code);
    }
}
