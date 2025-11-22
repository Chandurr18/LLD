package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Concrete state representing a failed payment with a reason.
 */
public class FailedState implements PaymentState {

    private final String reason;

    public FailedState(String reason) {
        this.reason = reason;
    }

    @Override
    public void process(PaymentTransaction tx) {
        System.out.println("FailedState: cannot process a failed payment. Reason: " + reason);
    }

    @Override
    public void cancel(PaymentTransaction tx) {
        System.out.println("FailedState: already failed, cancel redundant");
    }

    @Override
    public void refund(PaymentTransaction tx) {
        System.out.println("FailedState: cannot refund a failed payment");
    }

    @Override
    public String name() { return "FAILED"; }
}
