package DesignPatterns.CreationalPattern.AbstractFactory.Solution;

/**
 * 🏗️ Abstract Factory
 * Declares creation methods for related products.
 */
public interface PaymentPlatformFactory {
    PaymentService createPaymentService();
    NotificationService createNotificationService();
}
