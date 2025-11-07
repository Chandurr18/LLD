package SOLIDPrinciples.LiskovSubstitutionPrinciple.Solution;

/**
 * Demonstrates LSP-compliant design.
 */
public class ClientMain {
    public static void main(String[] args) {
        PaymentProcessor crypto = new CryptoPaymentProcessor();
        RefundablePaymentProcessor creditCard = new CreditCardProcessor();

        crypto.processPayment(200);
        creditCard.processPayment(100);
        creditCard.refund(50);
    }
}
