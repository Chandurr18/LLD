package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Concrete state representing a successfully completed payment.
 */
public class CompletedState implements PaymentState {

    @Override
    public void process(PaymentTransaction tx) {
        System.out.println("CompletedState: already completed, nothing to process");
    }

    @Override
    public void cancel(PaymentTransaction tx) {
        System.out.println("CompletedState: cannot cancel a completed payment");
    }

    @Override
    public void refund(PaymentTransaction tx) {
        System.out.println("CompletedState: refund allowed -> moving to RefundState");
        tx.setState(new RefundState());
    }

    @Override
    public String name() { return "COMPLETED"; }
}
