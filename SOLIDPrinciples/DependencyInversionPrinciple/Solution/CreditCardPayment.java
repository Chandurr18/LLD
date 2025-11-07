package SOLIDPrinciples.DependencyInversionPrinciple.Solution;

/**
 * Low-level module that depends on the abstraction (PaymentService).
 */
public class CreditCardPayment implements PaymentService {

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
