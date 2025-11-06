package SOLIDPrinciples.OpenClosedPrinciple.Solution;

public class CreditCardPayment implements PaymentMethod {
    @Override public String name() { return "CREDIT_CARD"; }
    @Override public void pay(double amount) {
        System.out.println("Charging ₹" + amount + " via Credit Card gateway...");
        // tokenize, authorize, capture...
    }
}
