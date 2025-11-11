package DesignPatterns.CreationalPattern.AbstractFactory.Solution;

/**
 * ✅ Client
 * Uses the abstract factory to create product families.
 */
public class Client {
    public static void main(String[] args) {

        System.out.println("---- Domestic Platform ----");
        PaymentPlatformFactory domesticFactory = new DomesticFactory();
        PaymentService domesticPayment = domesticFactory.createPaymentService();
        NotificationService domesticNotification = domesticFactory.createNotificationService();
        domesticPayment.makePayment(500);
        domesticNotification.notifyUser("Domestic payment of ₹500 completed.");

        System.out.println("\n---- International Platform ----");
        PaymentPlatformFactory internationalFactory = new InternationalFactory();
        PaymentService internationalPayment = internationalFactory.createPaymentService();
        NotificationService internationalNotification = internationalFactory.createNotificationService();
        internationalPayment.makePayment(10);
        internationalNotification.notifyUser("International payment of $10 completed.");
    }
}
