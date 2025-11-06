package SOLIDPrinciples.OpenClosedPrinciple.Solution;

public class UPIPayment implements PaymentMethod {
    @Override public String name() { return "UPI"; }
    @Override public void pay(double amount) {
        System.out.println("Charging ₹" + amount + " via UPI (collect request)...");
        // create collect request, poll status...
    }
}
