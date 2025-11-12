package CreationalPattern.AbstractFactory.Solution;

public class UPIPayment implements PaymentService {
    @Override
    public void makePayment(double amount) {
        System.out.println("💰 Domestic: UPI Payment of ₹" + amount);
    }
}
