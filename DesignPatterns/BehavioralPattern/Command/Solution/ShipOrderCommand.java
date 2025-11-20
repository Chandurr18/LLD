package DesignPatterns.BehavioralPattern.Command.Solution;

public class ShipOrderCommand implements Command {

    private OrderService service;
    private String orderId;

    public ShipOrderCommand(OrderService service, String orderId) {
        this.service = service;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        service.shipOrder(orderId);
    }

    @Override
    public void undo() {
        System.out.println("[ShipOrderCommand] Cannot undo shipping in real workflows.");
    }
}
