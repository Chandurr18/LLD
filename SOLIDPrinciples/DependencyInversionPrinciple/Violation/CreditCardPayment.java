package SOLIDPrinciples.DependencyInversionPrinciple.Violation;

/**
 * Low-level module for handling credit card payments.
 */
public class CreditCardPayment {

    public void makePayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
