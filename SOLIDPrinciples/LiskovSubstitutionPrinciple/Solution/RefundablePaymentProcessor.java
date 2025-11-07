package SOLIDPrinciples.LiskovSubstitutionPrinciple.Solution;

/**
 * Interface representing processors that support refunds.
 */
public interface RefundablePaymentProcessor extends PaymentProcessor {
    void refund(double amount);
}
