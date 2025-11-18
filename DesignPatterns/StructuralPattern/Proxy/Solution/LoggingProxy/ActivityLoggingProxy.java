package DesignPatterns.StructuralPattern.Proxy.Solution.LoggingProxy;

/**
 * Logging proxy adding audit logs around calls.
 */
public class ActivityLoggingProxy implements ActivityService {
    private final RealActivityService real = new RealActivityService();

    @Override
    public void record(String userId, String action) {
        System.out.println("[ActivityLoggingProxy] AUDIT START: " + userId + " -> " + action);
        real.record(userId, action);
        System.out.println("[ActivityLoggingProxy] AUDIT END");
    }
}
