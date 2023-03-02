package old;

import old.Page;
import old.PageModel;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

public interface RuntimeEnv {

    <T> void ok(T data);

    <T> void ok(Page<T> data);

    <T> void ok(List<T> data);

    <T> T body(Class<T> tClass);

    <T> T queryBody(Class<T> tClass);

    <T> T pathBody(Class<T> pClass);

    <T extends ValidObject> Future<T> validBody(Class<T> tClass);

    <T extends ValidObject> Future<T> validQueryBody(Class<T> tClass);

    PageModel page();

    void error(int hCode, int code, String msg);

    RoutingContext rtx();

    Vertx vertx();

    default <T> void bind(Future<T> data) {
        data.onSuccess(this::ok).onFailure(this::error);
    }

    default <T> void bindPage(Future<Page<T>> data) {
        data.onSuccess(this::ok).onFailure(this::error);
    }

    default <T> void bindList(Future<List<T>> data) {
        data.onSuccess(this::ok).onFailure(this::error);
    }

    default void error(int code, String msg) {
        error(500, code, msg);
    }

    default void error(Throwable throwable) {
        if (throwable == null) {
            error(500, "Unknown Error!");
        } else {
            if (throwable instanceof RVException tx) {
                error(tx.getCode(), throwable.getMessage());
            } else {
                error(500, throwable.getMessage());
            }
        }
    }
}
