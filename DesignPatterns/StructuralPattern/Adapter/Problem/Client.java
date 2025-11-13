/**
 * Demonstrates tight coupling when integrating third-party payment SDKs directly.
 * Each new SDK forces client code changes and violates Open/Closed Principle.
 */
public class Client {
    public static void main(String[] args) {
        // Direct usage of third-party SDKs (problem)
        PayPalAPI payPal = new PayPalAPI();
        payPal.makePayment(9999); // amount in cents

        RazorPayAPI razor = new RazorPayAPI();
        razor.processPayment("INR", 4999); // currency + amount in paise
    }
}