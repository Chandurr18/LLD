package SOLIDPrinciples.DependencyInversionPrinciple.Violation;

/**
 * High-level module directly depends on the low-level module.
 * 
 * This violates the Dependency Inversion Principle because
 * it creates tight coupling with CreditCardPayment.
 */
public class PaymentProcessor {

    private final CreditCardPayment creditCardPayment = new CreditCardPayment(); // ❌ Direct dependency

    public void process(double amount) {
        creditCardPayment.makePayment(amount);
    }
}
