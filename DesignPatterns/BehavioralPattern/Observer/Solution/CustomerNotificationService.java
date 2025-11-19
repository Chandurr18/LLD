package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Observer for notifying customers.
 */
public class CustomerNotificationService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[CustomerNotificationService] Customer notified: Order "
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
