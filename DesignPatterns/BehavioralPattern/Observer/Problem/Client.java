/**
 * Demonstrates the PROBLEM version of Observer:
 * OrderService is tightly coupled with all observers.
 */
public class Client {

    public static void main(String[] args) {

        Order order = new Order("ORD-1001");
        OrderService orderService = new OrderService();

        orderService.updateOrderStatus(order, "PACKED");
        orderService.updateOrderStatus(order, "SHIPPED");
        orderService.updateOrderStatus(order, "OUT_FOR_DELIVERY");
        orderService.updateOrderStatus(order, "DELIVERED");
    }
}
