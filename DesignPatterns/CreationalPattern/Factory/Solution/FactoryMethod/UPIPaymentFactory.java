package DesignPatterns.CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * Concrete Factory 1
 * Creates and returns a UPI Payment instance.
 */
public class UPIPaymentFactory extends PaymentProcessorFactory {

    @Override
    protected PaymentService createPaymentService() {
        System.out.println("🏦 Creating UPI Payment Service...");
        return new UPIPayment();
    }
}
