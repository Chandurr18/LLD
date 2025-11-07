package SOLIDPrinciples.DependencyInversionPrinciple.Solution;

/**
 * High-level module depends on abstraction, not concrete implementation.
 */
public class PaymentProcessor {

    private final PaymentService paymentService;

    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process(double amount) {
        paymentService.makePayment(amount);
    }
}
