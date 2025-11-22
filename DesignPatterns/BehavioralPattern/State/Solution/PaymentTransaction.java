package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Context holding a Payment and its current state.
 */
public class PaymentTransaction {

    private final Payment payment;   
    private PaymentState state;      

    public PaymentTransaction(Payment payment) {
        this.payment = payment;
        this.state = new PendingState(); 
        System.out.println("Creating transaction in Pending state...");
    }

    public Payment getPayment() { return payment; }  

    public void setState(PaymentState state) {
        System.out.println("Transition: " + this.state.name() + " -> " + state.name());
        this.state = state;
    }

    public void process() { state.process(this); }
    public void cancel() { state.cancel(this); }
    public void refund() { state.refund(this); }
}
