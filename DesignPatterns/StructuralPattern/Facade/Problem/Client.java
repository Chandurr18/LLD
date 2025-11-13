package StructuralPattern.Facade.Problem;
/**
 * Demonstrates the problem: client directly interacts with multiple subsystems
 * to place an order. This increases complexity and coupling.
 */
public class Client {
    public static void main(String[] args) {
        Order order = new Order("ORD123", "Laptop", 1, 95000.0);

        PaymentService payment = new PaymentService();
        InventoryService inventory = new InventoryService();
        ShippingService shipping = new ShippingService();
        NotificationService notification = new NotificationService();

        // The client coordinates everything manually (bad practice)
        if (inventory.checkStock(order)) {
            if (payment.processPayment(order)) {
                shipping.shipOrder(order);
                notification.sendConfirmation(order);
                System.out.println("✅ Order placed successfully!");
            }
        }
    }
}
