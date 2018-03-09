package io.schoolspointframework;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class JsonBodySpec {

    private static final String COMMON = ",";
    private static final String DBL = "\"";
    private static final String COLON = ":";
    private final StringBuilder json = new StringBuilder();

    JsonBodySpec() {
        json.append("{");
    }

    private Json end() {
        json.append("}");
        return new Json(json.toString());
    }

    private void it(String key, String value) {
        json.append(DBL).append(key).append(DBL).append(COLON).append(DBL).append(value).append(DBL);
    }

    public Json lastItem(String key, String value) {
        it(key, value);
        return end();
    }

    public JsonBodySpec item(String key, String value) {
        it(key, value);
        json.append(COMMON);
        return _this();
    }

    private JsonBodySpec _this() {
        return this;
    }
}
