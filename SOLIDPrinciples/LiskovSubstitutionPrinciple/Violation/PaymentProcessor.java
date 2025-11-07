package SOLIDPrinciples.LiskovSubstitutionPrinciple.Violation;

/**
 * Base class representing a generic payment processor.
 * 
 * Assumes that ALL payment types can process and refund payments.
 * But this assumption doesn't hold true for all subclasses.
 */
public abstract class PaymentProcessor {

    public abstract void processPayment(double amount);

    public abstract void refund(double amount);
}
