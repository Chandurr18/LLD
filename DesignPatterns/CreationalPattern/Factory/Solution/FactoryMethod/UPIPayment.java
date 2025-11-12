package CreationalPattern.Factory.Solution.FactoryMethod;

/**
 * Concrete Product A
 * Implements payment via UPI.
 */
public class UPIPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("💸 Processing ₹" + amount + " using UPI Payment.");
    }
}
