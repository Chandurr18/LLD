package DesignPatterns.BehavioralPattern.Command.Solution;

public class PlaceOrderCommand implements Command {

    private OrderService service;
    private String orderId;

    public PlaceOrderCommand(OrderService service, String orderId) {
        this.service = service;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        service.placeOrder(orderId);
    }

    @Override
    public void undo() {
        service.cancelOrder(orderId);
    }
}
