package DesignPatterns.CreationalPattern.Factory.Solution.SimpleFactory;

/**
 * Concrete product: UPI payment implementation.
 */
public class UPIPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("✅ UPI Payment processed for ₹" + amount);
    }
}
