package StructuralPattern.Facade.Solution;

public class ShippingService {
    public void shipOrder(Order order) {
        System.out.println("🚚 Shipping order: " + order.getOrderId() + " for " + order.getProduct());
    }
}
