package DesignPatterns.BehavioralPattern.State.Problem;

/**
 * Demonstrates how clients must know about enums and conditional semantics.
 */
public class Client {
    public static void main(String[] args) {
        Payment payment = new Payment("PAY-1001", 1500);
        PaymentProcessor processor = new PaymentProcessor();

        processor.handle(payment, Payment.Status.PENDING);
        processor.handle(payment, Payment.Status.PROCESSING);
        processor.handle(payment, Payment.Status.COMPLETED);

        processor.refund(payment, Payment.Status.COMPLETED);
    }
}
