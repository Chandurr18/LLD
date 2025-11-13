package StructuralPattern.Facade.Problem;

/*
 * Inventory Service
 */
public class InventoryService {
    public boolean checkStock(Order order) {
        System.out.println("📦 Checking stock for " + order.getProduct() + " (Qty: " + order.getQuantity() + ")");
        return true;
    }
}
