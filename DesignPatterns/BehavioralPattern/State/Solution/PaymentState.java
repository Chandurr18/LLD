package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * State interface for PaymentTransaction lifecycle actions.
 */
public interface PaymentState {
    void process(PaymentTransaction tx); 
    void cancel(PaymentTransaction tx);  
    void refund(PaymentTransaction tx);  
    String name();                       
}
