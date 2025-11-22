package DesignPatterns.BehavioralPattern.State.Solution;

/**
 * Demonstrates State pattern with PaymentTransaction lifecycle.
 */
public class Client {
    public static void main(String[] args) {

        Payment payment = new Payment("PAY-5001", 1999.99);
        PaymentTransaction tx = new PaymentTransaction(payment);

        tx.process();   
        System.out.println("Attempting refund...");
        tx.refund();    
    }
}
