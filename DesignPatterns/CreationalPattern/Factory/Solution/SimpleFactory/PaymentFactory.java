package DesignPatterns.CreationalPattern.Factory.Solution.SimpleFactory;
/**
 * 💡 Factory class responsible for creating appropriate payment instances.
 * Centralizes creation logic and returns PaymentService interface.
 */
public class PaymentFactory {

    public static PaymentService getPaymentService(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
        switch (type.toUpperCase()) {
            case "UPI":
                return new UPIPayment();
            case "CREDITCARD":
                return new CreditCardPayment();
            default:
                throw new UnsupportedOperationException("Unknown payment type: " + type);
        }
    }
}
