package CreationalPattern.Factory.Solution.SimpleFactory;

/**
 * ✅ Common abstraction for all payment types.
 */
public interface PaymentService {
    void makePayment(double amount);
}
