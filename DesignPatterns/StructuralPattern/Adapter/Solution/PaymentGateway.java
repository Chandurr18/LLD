package StructuralPattern.Adapter.Solution;

/**
 * Target interface expected by the client and the application.
 */
public interface PaymentGateway {
    /**
     * Process payment for the given amount in major currency (e.g., INR, USD).
     * 
     * @param amount amount in major currency units (e.g., 99.99)
     */
    void pay(double amount);
}