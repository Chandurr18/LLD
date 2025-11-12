package CreationalPattern.AbstractFactory.Solution;

public class PayPalPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("🌍 International: PayPal Payment of $" + amount);
    }
}
