package ink.wulian.home.common.utils;

import io.vertx.core.http.HttpServerRequest;

import java.util.HashMap;
import java.util.Map;

public class HttpContextUtils {

    private HttpContextUtils() {
    }

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String JSON = "json";

    public static final String JSON_UTF8 = "application/json;charset=utf-8";

    public static Map<String, String> getHeaders(HttpServerRequest request) {
        HashMap<String, String> headers = new HashMap<>();
        request.headers().forEach(header -> headers.put(header.getKey(), header.getValue()));
        return headers;
    }

}
