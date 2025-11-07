package SOLIDPrinciples.DependencyInversionPrinciple.Solution;

/**
 * Demonstrates Dependency Inversion Principle compliance.
 */
public class ClientMain {
    public static void main(String[] args) {
        PaymentService creditCard = new CreditCardPayment();
        PaymentService upi = new UPIPayment();

        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        processor1.process(200.0);

        PaymentProcessor processor2 = new PaymentProcessor(upi);
        processor2.process(150.0);
    }
}
