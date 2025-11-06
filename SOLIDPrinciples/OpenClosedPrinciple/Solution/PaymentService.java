package SOLIDPrinciples.OpenClosedPrinciple.Solution;

/**
 * Closed for modification: does not care about concrete types.
 * Open for extension: accepts any PaymentMethod.
 */
public class PaymentService {
    public void process(PaymentMethod method, double amount) {
        System.out.println("Processing payment using: " + method.name());
        method.pay(amount);
    }
}
