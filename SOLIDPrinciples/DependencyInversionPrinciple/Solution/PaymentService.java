package SOLIDPrinciples.DependencyInversionPrinciple.Solution;

/**
 * Abstraction that defines a contract for payment services.
 */
public interface PaymentService {
    void makePayment(double amount);
}
