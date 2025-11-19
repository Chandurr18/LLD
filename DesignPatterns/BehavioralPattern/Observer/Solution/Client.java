package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Demonstrates the Observer Pattern in action.
 */
public class Client {
    public static void main(String[] args) {

        OrderStatusPublisher publisher = new OrderStatusPublisher();

        // Register observers
        publisher.attach(new CustomerNotificationService());
        publisher.attach(new WarehouseService());
        publisher.attach(new DeliveryPartnerService());
        publisher.attach(new AnalyticsService());

        // Create order
        Order order = new Order("ORD-2001", publisher);

        order.updateStatus("PACKED");
        order.updateStatus("SHIPPED");
        order.updateStatus("OUT_FOR_DELIVERY");
        order.updateStatus("DELIVERED");
    }
}
