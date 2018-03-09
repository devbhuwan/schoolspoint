package io.schoolspointframework;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public class Json {

    private String _json;

    Json(String json) {
        this._json = json;
    }

    public static JsonBodySpec start() {
        return new JsonBodySpec();
    }

    public String json() {
        return _json;
    }

}
