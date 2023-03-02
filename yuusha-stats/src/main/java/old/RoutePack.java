package old;

public interface RoutePack {
    RoutePack put(String path, RouteOne routeOne);
    RoutePack get(String path, RouteOne routeOne);
    RoutePack post(String path, RouteOne routeOne);
    RoutePack delete(String path, RouteOne routeOne);
}
