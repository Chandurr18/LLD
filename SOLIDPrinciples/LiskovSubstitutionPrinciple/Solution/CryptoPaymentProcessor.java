package SOLIDPrinciples.LiskovSubstitutionPrinciple.Solution;

/**
 * CryptoPaymentProcessor supports only payments, not refunds.
 * 
 * By separating interfaces, this class no longer violates LSP.
 */
public class CryptoPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
    }
}
