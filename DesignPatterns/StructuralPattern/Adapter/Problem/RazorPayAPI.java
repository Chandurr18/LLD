/**
 * Simulated third-party RazorPay SDK (incompatible interface)
 */
public class RazorPayAPI {
    public void processPayment(String currency, int amountInPaise) {
        System.out.println("[RazorPayAPI] Processing payment of " + currency + " " + (amountInPaise / 100.0));
    }
}