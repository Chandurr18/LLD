package DesignPatterns.CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * Concrete Product B
 * Implements payment via Credit Card.
 */
public class CreditCardPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("💳 Processing ₹" + amount + " using Credit Card Payment.");
    }
}
