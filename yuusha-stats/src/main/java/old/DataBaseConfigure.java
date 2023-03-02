package old;

public interface DataBaseConfigure {
    DataBaseConfigure host(String host);

    DataBaseConfigure port(int port);

    DataBaseConfigure db(String db);

    DataBaseConfigure user(String user);

    DataBaseConfigure password(String password);

    DataBaseConfigure pool(int size);

    DataBaseConfigure pipe(int limit);

    DataBaseConfigure connectTimeOut(int connectTimeOut);

    DataBaseConfigure reconnectInterval(int reconnectInterval);

    DataBaseConfigure reconnectAttempt(int reconnectAttempt);
}
