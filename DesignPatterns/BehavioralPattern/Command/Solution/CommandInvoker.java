package DesignPatterns.BehavioralPattern.Command.Solution;

import java.util.Stack;

public class CommandInvoker {

    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("[Invoker] Nothing to undo.");
        }
    }
}
