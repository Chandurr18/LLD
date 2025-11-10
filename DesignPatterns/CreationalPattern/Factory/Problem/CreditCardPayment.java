package DesignPatterns.CreationalPattern.Factory.Problem;

/**
 * Credit Card payment concrete implementation.
 */
public class CreditCardPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " via Credit Card...");
    }
}
