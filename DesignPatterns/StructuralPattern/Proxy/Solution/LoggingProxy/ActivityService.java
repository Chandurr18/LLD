package DesignPatterns.StructuralPattern.Proxy.Solution.LoggingProxy;

/**
 * Subject: ActivityService - records user actions.
 */
public interface ActivityService {
    void record(String userId, String action);
}
