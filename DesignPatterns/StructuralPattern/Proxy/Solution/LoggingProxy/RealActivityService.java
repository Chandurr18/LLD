package DesignPatterns.StructuralPattern.Proxy.Solution.LoggingProxy;

/**
 * RealActivityService - performs action recording.
 */
public class RealActivityService implements ActivityService {
    @Override
    public void record(String userId, String action) {
        System.out.println("[RealActivityService] Recording: " + userId + " -> " + action);
    }
}
