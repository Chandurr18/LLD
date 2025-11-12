package HTTPRequestExample;
/**
 * ❌ Problem:
 * Too many constructor parameters make the object creation complex and error-prone.
 * Imagine maintaining multiple overloaded constructors for different use cases.
 */
public class HttpRequest {

    private final String url;
    private final String method;
    private final String body;
    private final int timeout;
    private final boolean followRedirects;
    private final String contentType;
    private final String authToken;

    // Telescoping constructor - hard to read and maintain
    public HttpRequest(String url, String method, String body, int timeout,
                       boolean followRedirects, String contentType, String authToken) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.timeout = timeout;
        this.followRedirects = followRedirects;
        this.contentType = contentType;
        this.authToken = authToken;
    }

    public HttpRequest(String url, String method, String body, int timeout, String contentType, String authToken) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.timeout = timeout;
        this.followRedirects = false;
        this.contentType = contentType;
        this.authToken = authToken;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                ", followRedirects=" + followRedirects +
                ", contentType='" + contentType + '\'' +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
