package DesignPatterns.CreationalPattern.Factory.Problem;

/**
 * ❌ Represents a high-level payment service tightly coupled
 * with concrete implementations. Violates OCP and DIP.
 */
public interface PaymentService {
    void makePayment(double amount);
}
