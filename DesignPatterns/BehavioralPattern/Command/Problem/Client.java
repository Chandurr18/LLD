/**
 * Demonstrates the PROBLEM version of Command Pattern:
 * No command abstraction, no undo, tightly coupled calls.
 */
public class Client {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        service.placeOrder("ORD-101");
        service.shipOrder("ORD-101");
        service.notifyUser("ORD-101", "Your order has been shipped!");
        service.cancelOrder("ORD-101");
        service.refundOrder("ORD-101");
    }
}
