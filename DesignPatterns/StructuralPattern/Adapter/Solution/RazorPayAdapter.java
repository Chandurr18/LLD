package DesignPatterns.StructuralPattern.Adapter.Solution;

/**
 * Object Adapter for RazorPayAPI.
 * Implements PaymentGateway and uses RazorPayAPI internally.
 */
public class RazorPayAdapter implements PaymentGateway {

    private final RazorPayAPI razorPayAPI;
    private final String currency; // e.g., "INR"

    public RazorPayAdapter(RazorPayAPI razorPayAPI, String currency) {
        this.razorPayAPI = razorPayAPI;
        this.currency = currency;
    }

    @Override
    public void pay(double amount) {
        // Convert major currency to paise for RazorPayAPI (e.g., 99.99 -> 9999 paise)
        int paise = (int) Math.round(amount * 100);
        System.out.println("[RazorPayAdapter] Adapting pay(" + amount + ") -> processPayment(" + currency + ", " + paise + ")");
        razorPayAPI.processPayment(currency, paise);
    }
}