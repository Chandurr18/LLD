/**
 * International payment implementation.
 */
public class PayPalPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("🌍 Processing $" + amount + " via PayPal Payment.");
    }
}
