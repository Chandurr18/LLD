package DesignPatterns.StructuralPattern.Adapter.Solution;

/**
 * Demonstrates Adapter Pattern in action.
 */
public class Client {
    public static void main(String[] args) {
        // Create third-party SDK instances (Adaptees)
        PayPalAPI payPalAPI = new PayPalAPI();
        RazorPayAPI razorPayAPI = new RazorPayAPI();

        // Wrap them with adapters that implement our PaymentGateway (Target)
        PaymentGateway payPalGateway = new PayPalAdapter(payPalAPI);
        PaymentGateway razorGateway = new RazorPayAdapter(razorPayAPI, "INR");

        // PaymentProcessor depends on PaymentGateway only (decoupled)
        PaymentProcessor processor1 = new PaymentProcessor(payPalGateway);
        PaymentProcessor processor2 = new PaymentProcessor(razorGateway);

        // Use processors - no client code changes needed when adding new SDKs
        processor1.checkout(99.99);
        System.out.println("--------------------------");
        processor2.checkout(49.99);
    }
}