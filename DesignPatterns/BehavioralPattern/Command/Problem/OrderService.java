/**
 * ❌ Problem Version:
 * Direct method calls without Command Pattern or Undo support.
 */
public class OrderService {

    public void placeOrder(String orderId) {
        System.out.println("[OrderService] Order placed: " + orderId);
    }

    public void cancelOrder(String orderId) {
        System.out.println("[OrderService] Order cancelled: " + orderId);
    }

    public void refundOrder(String orderId) {
        System.out.println("[OrderService] Order refunded: " + orderId);
    }

    public void shipOrder(String orderId) {
        System.out.println("[OrderService] Order shipped: " + orderId);
    }

    public void notifyUser(String orderId, String message) {
        System.out.println("[OrderService] Notification sent to user for Order "
                + orderId + ": " + message);
    }
}
