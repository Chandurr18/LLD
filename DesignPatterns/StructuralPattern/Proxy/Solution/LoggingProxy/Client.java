package DesignPatterns.StructuralPattern.Proxy.Solution.LoggingProxy;

/**
 * Client demonstrates logging proxy usage.
 */
public class Client {
    public static void main(String[] args) {
        ActivityService svc = new ActivityLoggingProxy();
        svc.record("user-1", "LOGIN");
        svc.record("user-1", "LOGOUT");
    }
}
