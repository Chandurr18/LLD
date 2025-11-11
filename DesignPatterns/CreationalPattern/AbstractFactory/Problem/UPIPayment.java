/**
 * Domestic payment implementation.
 */
public class UPIPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("💸 Processing ₹" + amount + " via UPI Payment.");
    }
}
