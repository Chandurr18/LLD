package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Observer for delivery partner updates.
 */
public class DeliveryPartnerService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[DeliveryPartnerService] Delivery partner updated: Order "
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
