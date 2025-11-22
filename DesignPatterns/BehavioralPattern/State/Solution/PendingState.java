package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Concrete state representing a pending payment.
 */
public class PendingState implements PaymentState {

    @Override
    public void process(PaymentTransaction tx) {
        System.out.println("PendingState: starting processing -> moving to ProcessingState");
        tx.setState(new ProcessingState());
    }

    @Override
    public void cancel(PaymentTransaction tx) {
        System.out.println("PendingState: canceling payment -> moving to FailedState");
        tx.setState(new FailedState("Cancelled by user"));
    }

    @Override
    public void refund(PaymentTransaction tx) {
        System.out.println("PendingState: cannot refund a pending payment");
    }

    @Override
    public String name() { return "PENDING"; }
}
