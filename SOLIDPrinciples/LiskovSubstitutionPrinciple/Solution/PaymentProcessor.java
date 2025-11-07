package SOLIDPrinciples.LiskovSubstitutionPrinciple.Solution;

/**
 * Base interface representing a generic payment processor.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}