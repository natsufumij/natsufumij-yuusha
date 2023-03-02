package old;

import io.vertx.core.json.JsonObject;

import java.util.List;

public interface Valid {
    record InValidInfo(List<String> msg) {
    }

    InValidInfo valid(JsonObject object);

    default Valid notNull(String key) {
        return notNull(key, key);
    }

    default Valid notBlank(String key) {
        return notBlank(key, key);
    }

    default Valid strLength(String key, int min, int max) {
        return strLength(key, key, min, max);
    }

    default Valid number(String key, int min, int max) {
        return number(key, key, min, max);
    }

    default Valid strMatch(String key, String match) {
        return strMatch(key, key, match);
    }

    Valid notNull(String key, String name);

    Valid notBlank(String key, String name);

    Valid strLength(String key, String name, int min, int max);

    Valid number(String key, String name, int min, int max);

    Valid strMatch(String key, String tip, String match);
}
