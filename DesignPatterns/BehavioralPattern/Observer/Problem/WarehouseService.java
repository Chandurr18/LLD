/**
 * Warehouse system that updates stock and packing operations.
 */
public class WarehouseService {

    public void updateWarehouse(Order order) {
        System.out.println("[WarehouseService] Warehouse updated: Order " 
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
