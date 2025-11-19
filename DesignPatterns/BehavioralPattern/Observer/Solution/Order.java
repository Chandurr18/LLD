package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Order class whose status changes trigger observer notifications.
 */
public class Order {

    private final String orderId;
    private String status;
    private OrderStatusPublisher publisher;

    public Order(String orderId, OrderStatusPublisher publisher) {
        this.orderId = orderId;
        this.status = "PLACED";
        this.publisher = publisher;
    }

    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }

    public void updateStatus(String newStatus) {
        System.out.println("[Order] Updating status: " + this.status + " -> " + newStatus);
        this.status = newStatus;
        publisher.notifyAllObservers(this);
    }
}
