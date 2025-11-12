package CreationalPattern.Factory.Solution.SimpleFactory;

/**
 * Concrete product: Credit Card payment implementation.
 */
public class CreditCardPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("✅ Credit Card Payment processed for ₹" + amount);
    }
}
