package SOLIDPrinciples.OpenClosedPrinciple.Solution;

public interface PaymentMethod {
    String name(); // e.g., "CREDIT_CARD", "UPI"
    void pay(double amount);
}
