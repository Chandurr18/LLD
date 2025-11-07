package SOLIDPrinciples.LiskovSubstitutionPrinciple.Violation;

/**
 * CryptoPaymentProcessor violates LSP because it cannot support refunds.
 * 
 * But it is forced to implement the refund() method due to base class contract.
 */
public class CryptoPaymentProcessor extends PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
    }

    @Override
    public void refund(double amount) {
        throw new UnsupportedOperationException("Refunds not supported for crypto payments!");
    }
}
