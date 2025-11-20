package DesignPatterns.BehavioralPattern.Command.Solution;

public class Client {

    public static void main(String[] args) {

        OrderService service = new OrderService();
        CommandInvoker invoker = new CommandInvoker();

        invoker.executeCommand(new PlaceOrderCommand(service, "ORD-500"));
        invoker.executeCommand(new ShipOrderCommand(service, "ORD-500"));
        invoker.executeCommand(new NotifyUserCommand(service, "ORD-500", "Your order has shipped!"));
        invoker.executeCommand(new CancelOrderCommand(service, "ORD-500"));

        System.out.println("\n--- Undo operations ---");
        invoker.undoLast();
        invoker.undoLast();
    }
}
