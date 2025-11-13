package StructuralPattern.Adapter.Solution;

/**
 * Simulated third-party PayPal SDK (unchangeable).
 * Kept here for the example; in real projects this would be in an external
 * library.
 */
public class PayPalAPI {
    public void makePayment(int amountInCents) {
        System.out.println("[PayPalAPI] Processing payment of $" + (amountInCents / 100.0));
    }
}