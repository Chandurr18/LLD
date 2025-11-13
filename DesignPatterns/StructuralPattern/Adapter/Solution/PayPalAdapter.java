package StructuralPattern.Adapter.Solution;

/**
 * Object Adapter for PayPalAPI.
 * Implements the application's PaymentGateway (Target) and delegates to
 * PayPalAPI (Adaptee).
 */
public class PayPalAdapter implements PaymentGateway {

    private final PayPalAPI payPalAPI;

    public PayPalAdapter(PayPalAPI payPalAPI) {
        this.payPalAPI = payPalAPI;
    }

    @Override
    public void pay(double amount) {
        // Convert major currency to cents expected by PayPalAPI
        int cents = (int) Math.round(amount * 100);
        System.out.println("[PayPalAdapter] Adapting pay(" + amount + ") -> makePayment(" + cents + ")");
        payPalAPI.makePayment(cents);
    }
}