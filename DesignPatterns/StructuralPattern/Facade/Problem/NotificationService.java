package StructuralPattern.Facade.Problem;

/*
 * Notification Service
 */
public class NotificationService {
    public void sendConfirmation(Order order) {
        System.out.println("📧 Sending confirmation email for Order ID: " + order.getOrderId());
    }
}
