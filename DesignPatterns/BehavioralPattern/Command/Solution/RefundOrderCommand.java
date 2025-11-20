package DesignPatterns.BehavioralPattern.Command.Solution;

public class RefundOrderCommand implements Command {

    private OrderService service;
    private String orderId;

    public RefundOrderCommand(OrderService service, String orderId) {
        this.service = service;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        service.refundOrder(orderId);
    }

    @Override
    public void undo() {
        System.out.println("[RefundOrderCommand] Undoing refund not supported realistically.");
    }
}
