package StructuralPattern.Facade.Solution;

public class Client {
    public static void main(String[] args) {
        Order order = new Order("ORD123", "Laptop", 1, 95000.0);

        // Client uses only the Facade instead of multiple subsystems
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder(order);
    }
}
