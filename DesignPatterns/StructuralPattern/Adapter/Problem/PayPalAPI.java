/**
 * Simulated third-party PayPal SDK (incompatible interface)
 */
public class PayPalAPI {
    public void makePayment(int amountInCents) {
        System.out.println("[PayPalAPI] Processing payment of $" + (amountInCents / 100.0));
    }
}