package SOLIDPrinciples.OpenClosedPrinciple.Violation;

public class Checkout {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment("CREDIT_CARD", 1299.00);
        service.processPayment("UPI", 899.00);
    }
}
