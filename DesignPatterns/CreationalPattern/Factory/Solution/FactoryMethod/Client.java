package CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * ✅ Client
 * Uses the abstract factory reference to process payments.
 * Client is decoupled from concrete product classes.
 */
public class Client {

    public static void main(String[] args) {

        PaymentProcessorFactory upiFactory = new UPIPaymentFactory();
        upiFactory.processPayment(2000);

        System.out.println("--------------------------");

        PaymentProcessorFactory creditCardFactory = new CreditCardPaymentFactory();
        creditCardFactory.processPayment(5000);
    }
}
