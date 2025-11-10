package DesignPatterns.CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * 🏗️ Creator (Abstract Factory)
 * Declares the factory method that returns a PaymentService.
 * Subclasses will override this method to decide which product to create.
 */
public abstract class PaymentProcessorFactory {

    /**
     * Factory Method — implemented by subclasses.
     */
    protected abstract PaymentService createPaymentService();

    /**
     * High-level logic shared across all factories.
     */
    public void processPayment(double amount) {
        PaymentService paymentService = createPaymentService();
        paymentService.makePayment(amount);
    }
}
