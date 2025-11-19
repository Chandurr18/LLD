/**
 * Represents an Order with basic details.
 */
public class Order {

    private final String orderId;
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "PLACED";
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        System.out.println("[Order] Updating status: " + this.status + " -> " + newStatus);
        this.status = newStatus;
    }
}
