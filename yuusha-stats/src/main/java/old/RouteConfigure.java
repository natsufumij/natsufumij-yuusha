package old;

import io.vertx.core.Vertx;

public interface RouteConfigure {
    RouteConfigure route(String basePath, ConfigRoute r);
    RouteConfigure port(int port);
    void config(Vertx vertx);
}
