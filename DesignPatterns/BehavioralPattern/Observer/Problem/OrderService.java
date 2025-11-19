/**
 * ❌ Problem Version:
 * OrderService handles business logic AND NOTIFICATIONS.
 *
 * Issues:
 * - Hardcoded dependencies on multiple services
 * - Violates Open/Closed Principle
 * - Violates Single Responsibility Principle
 * - Every new observer requires modifying this class
 */
public class OrderService {

    private CustomerNotificationService customerService = new CustomerNotificationService();
    private WarehouseService warehouseService = new WarehouseService();
    private DeliveryPartnerService deliveryService = new DeliveryPartnerService();
    private AnalyticsService analyticsService = new AnalyticsService();

    public void updateOrderStatus(Order order, String newStatus) {

        // 1. Update the order
        order.updateStatus(newStatus);

        // 2. Notify all dependent systems (hardcoded)
        customerService.notifyCustomer(order);
        warehouseService.updateWarehouse(order);
        deliveryService.updateDeliveryPartner(order);
        analyticsService.recordEvent(order);
    }
}
