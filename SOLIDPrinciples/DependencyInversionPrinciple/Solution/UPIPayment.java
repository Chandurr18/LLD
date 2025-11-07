package SOLIDPrinciples.DependencyInversionPrinciple.Solution;

/**
 * Another low-level module implementing the same abstraction.
 */
public class UPIPayment implements PaymentService {

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
    }
}
