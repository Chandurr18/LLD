package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Concrete state representing a refund in progress or completed.
 */
public class RefundState implements PaymentState {

    @Override
    public void process(PaymentTransaction tx) {
        System.out.println("RefundState: cannot process while refunding");
    }

    @Override
    public void cancel(PaymentTransaction tx) {
        System.out.println("RefundState: cannot cancel during refund");
    }

    @Override
    public void refund(PaymentTransaction tx) {
        System.out.println("RefundState: refund completed");
    }

    @Override
    public String name() { return "REFUND"; }
}
