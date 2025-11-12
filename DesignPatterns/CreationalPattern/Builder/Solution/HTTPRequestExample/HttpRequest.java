package CreationalPattern.Builder.Solution.HTTPRequestExample;


import java.util.HashMap;
import java.util.Map;

/**
 * ✅ Builder Pattern: Used for constructing complex HTTP Request objects.
 * Industry-style example inspired by HttpClient/OkHttp.
 */
public class HttpRequest {

    // Required parameters
    private final String url;
    private final String method;

    // Optional parameters
    private final String body;
    private final Map<String, String> headers;
    private final int timeout;
    private final boolean followRedirects;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;
        this.timeout = builder.timeout;
        this.followRedirects = builder.followRedirects;
    }

    public void execute() {
        // Simulate execution
        System.out.println("🚀 Sending " + method + " request to " + url);
        System.out.println("Headers: " + headers);
        System.out.println("Timeout: " + timeout + " ms");
        System.out.println("Follow Redirects: " + followRedirects);
        if (body != null) {
            System.out.println("Body: " + body);
        }
        System.out.println("✅ Request sent successfully!\n");
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                ", headers=" + headers +
                ", timeout=" + timeout +
                ", followRedirects=" + followRedirects +
                '}';
    }

    // ================================
    // Builder Class
    // ================================
    public static class Builder {
        private final String url;
        private final String method;
        private String body;
        private final Map<String, String> headers = new HashMap<>();
        private int timeout = 3000; // default
        private boolean followRedirects = true;

        public Builder(String url, String method) {
            this.url = url;
            this.method = method;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder followRedirects(boolean follow) {
            this.followRedirects = follow;
            return this;
        }

        public HttpRequest build() {
            if (url == null || method == null) {
                throw new IllegalStateException("URL and method must not be null");
            }
            return new HttpRequest(this);
        }
    }
}
