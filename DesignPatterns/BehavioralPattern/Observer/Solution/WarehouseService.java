package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Observer for updating warehouse systems.
 */
public class WarehouseService implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[WarehouseService] Warehouse updated: Order "
                + order.getOrderId() + " is now " + order.getStatus());
    }
}
