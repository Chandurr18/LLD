package DesignPatterns.BehavioralPattern.Command.Solution;

public class CancelOrderCommand implements Command {

    private OrderService service;
    private String orderId;

    public CancelOrderCommand(OrderService service, String orderId) {
        this.service = service;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        service.cancelOrder(orderId);
    }

    @Override
    public void undo() {
        service.placeOrder(orderId);
    }
}
