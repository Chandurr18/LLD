package DesignPatterns.CreationalPattern.Factory.Solution.SimpleFactory;

/**
 * ✅ Client depends only on abstraction (PaymentService)
 * and requests instances through PaymentFactory.
 */
public class Client {
    public static void main(String[] args) {

        PaymentService upi = PaymentFactory.getPaymentService("UPI");
        upi.makePayment(1500);

        PaymentService card = PaymentFactory.getPaymentService("CREDITCARD");
        card.makePayment(3000);

        // Adding new payment type requires modifying only the factory,
        // not the client.
    }
}

