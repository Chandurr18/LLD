package DesignPatterns.CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * Concrete Factory 2
 * Creates and returns a Credit Card Payment instance.
 */
public class CreditCardPaymentFactory extends PaymentProcessorFactory {

    @Override
    protected PaymentService createPaymentService() {
        System.out.println("🏦 Creating Credit Card Payment Service...");
        return new CreditCardPayment();
    }
}

