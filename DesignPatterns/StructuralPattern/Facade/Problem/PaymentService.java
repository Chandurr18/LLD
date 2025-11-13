package StructuralPattern.Facade.Problem;

/*
 * Payment Service
 */
public class PaymentService {
    public boolean processPayment(Order order) {
        System.out.println("💳 Processing payment of ₹" + order.getAmount() + " for " + order.getProduct());
        return true;
    }
}
