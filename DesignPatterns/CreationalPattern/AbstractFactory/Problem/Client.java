/**
 * ❌ Problem:
 * Client is responsible for deciding which concrete products to create.
 * Results in tight coupling, duplicate logic, and hard-coded dependencies.
 */
public class Client {
    public static void main(String[] args) {

        // Domestic logic
        PaymentService upi = new UPIPayment();
        NotificationService sms = new SMSNotification();
        upi.makePayment(500);
        sms.notifyUser("Domestic payment of ₹500 completed.");

        // International logic
        PaymentService paypal = new PayPalPayment();
        NotificationService email = new EmailNotification();
        paypal.makePayment(10);
        email.notifyUser("International payment of $10 completed.");
    }
}
