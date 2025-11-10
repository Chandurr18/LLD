package DesignPatterns.CreationalPattern.Factory.Problem;

/**
 * ❌ Problem:
 * Client directly instantiates specific payment classes.
 * To add new types, this class must change — violating OCP.
 */
public class Client {
    public static void main(String[] args) {
        PaymentService upi = new UPIPayment();
        upi.makePayment(1200);

        PaymentService card = new CreditCardPayment();
        card.makePayment(2500);
    }
}

