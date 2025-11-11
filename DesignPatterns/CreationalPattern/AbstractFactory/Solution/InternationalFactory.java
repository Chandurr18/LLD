package DesignPatterns.CreationalPattern.AbstractFactory.Solution;

/**
 * Concrete Factory 2 — International environment.
 */
public class InternationalFactory implements PaymentPlatformFactory {

    @Override
    public PaymentService createPaymentService() {
        System.out.println("🏦 Creating International Payment Service...");
        return new PayPalPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        System.out.println("🏦 Creating International Notification Service...");
        return new EmailNotification();
    }
}
