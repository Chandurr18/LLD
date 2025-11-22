package DesignPatterns.BehavioralPattern.State.Problem;

/**
 * ❌ Problem:
 * Monolithic payment processor using enum-based conditionals.
 * Behavior heavily depends on 'status' field and many if/else blocks.
 */
public class PaymentProcessor {

    public void handle(Payment payment, Payment.Status status) {
        if (status == Payment.Status.PENDING) {
            System.out.println("PENDING -> starting processing...");
            System.out.println("PENDING -> either PROCESSING or FAILED");
        } else if (status == Payment.Status.PROCESSING) {
            System.out.println("PROCESSING -> attempting commit...");
            System.out.println("PROCESSING -> either COMPLETED or FAILED");
        } else if (status == Payment.Status.COMPLETED) {
            System.out.println("COMPLETED -> can refund");
        } else if (status == Payment.Status.FAILED) {
            System.out.println("FAILED -> retry or cancel");
        } else if (status == Payment.Status.REFUNDED) {
            System.out.println("REFUNDED -> nothing to do");
        } else {
            System.out.println("UNKNOWN STATE");
        }
    }

    public void refund(Payment payment, Payment.Status status) {
        if (status == Payment.Status.COMPLETED) {
            System.out.println("Refunding payment: " + payment.getId());
        } else {
            System.out.println("Cannot refund in state: " + status);
        }
    }
}
