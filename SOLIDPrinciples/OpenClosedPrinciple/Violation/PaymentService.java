package SOLIDPrinciples.OpenClosedPrinciple.Violation;

/**
 * OCP Violation:
 * Adding ANY new payment method requires modifying this class.
 */
public class PaymentService {

    public void processPayment(String paymentType, double amount) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card payment of ₹" + amount);
            // Credit card gateway logic...
        }
        else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI payment of ₹" + amount);
            // UPI API call logic...
        }
        // 🚨 New payment method?
        // We must edit this class = OCP violation
        else {
            throw new UnsupportedOperationException("Unsupported payment method: " + paymentType);
        }
    }
}
