package SOLIDPrinciples.LiskovSubstitutionPrinciple.Violation;

/**
 * CreditCardProcessor supports both payments and refunds.
 */
public class CreditCardProcessor extends PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding credit card payment of $" + amount);
    }
}
