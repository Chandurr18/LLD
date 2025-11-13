package StructuralPattern.Facade.Solution;

/**
 * ✅ Facade class that provides a unified interface for the client.
 * It hides the complexity of coordinating multiple subsystems.
 */
public class OrderFacade {

    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(Order order) {
        System.out.println("🛒 Starting order placement process for " + order.getProduct());
        if (inventoryService.checkStock(order)) {
            if (paymentService.processPayment(order)) {
                shippingService.shipOrder(order);
                notificationService.sendConfirmation(order);
                System.out.println("✅ Order placed successfully!");
            }
        }
    }
}
