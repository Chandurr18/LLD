package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Observer for analytics event tracking.
 */
public class AnalyticsService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[AnalyticsService] Event recorded: Order "
                + order.getOrderId() + " changed to " + order.getStatus());
    }
}
