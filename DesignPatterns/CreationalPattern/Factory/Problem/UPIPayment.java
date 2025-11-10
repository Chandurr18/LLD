package DesignPatterns.CreationalPattern.Factory.Problem;

/**
 * UPI payment concrete implementation.
 */
public class UPIPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " via UPI...");
    }
}
