package DesignPatterns.CreationalPattern.AbstractFactory.Solution;

/**
 * Concrete Factory 1 — Domestic environment.
 */
public class DomesticFactory implements PaymentPlatformFactory {

    @Override
    public PaymentService createPaymentService() {
        System.out.println("🏦 Creating Domestic Payment Service...");
        return new UPIPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        System.out.println("🏦 Creating Domestic Notification Service...");
        return new SMSNotification();
    }
}
