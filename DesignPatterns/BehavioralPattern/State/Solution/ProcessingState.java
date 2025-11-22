package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Concrete state representing processing work with external gateway.
 */
public class ProcessingState implements PaymentState {

    @Override
    public void process(PaymentTransaction tx) {
        System.out.println("ProcessingState: processing... -> moving to CompletedState");
        tx.setState(new CompletedState());
    }

    @Override
    public void cancel(PaymentTransaction tx) {
        System.out.println("ProcessingState: attempting cancel -> moving to FailedState");
        tx.setState(new FailedState("Cancelled during processing"));
    }

    @Override
    public void refund(PaymentTransaction tx) {
        System.out.println("ProcessingState: cannot refund while processing");
    }

    @Override
    public String name() { return "PROCESSING"; }
}
