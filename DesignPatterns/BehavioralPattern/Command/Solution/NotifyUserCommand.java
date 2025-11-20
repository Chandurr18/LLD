package DesignPatterns.BehavioralPattern.Command.Solution;

public class NotifyUserCommand implements Command {

    private OrderService service;
    private String orderId;
    private String message;

    public NotifyUserCommand(OrderService service, String orderId, String message) {
        this.service = service;
        this.orderId = orderId;
        this.message = message;
    }

    @Override
    public void execute() {
        service.notifyUser(orderId, message);
    }

    @Override
    public void undo() {
        System.out.println("[NotifyUserCommand] Undoing notification (no-op).");
    }
}
