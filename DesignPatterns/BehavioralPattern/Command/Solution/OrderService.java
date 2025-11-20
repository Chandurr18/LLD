package DesignPatterns.BehavioralPattern.Command.Solution;

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
        System.out.println("[OrderService] Notification to " + orderId + ": " + message);
    }
}
