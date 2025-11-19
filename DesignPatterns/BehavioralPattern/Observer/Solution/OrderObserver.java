package DesignPatterns.BehavioralPattern.Observer.Solution;

/**
 * Observer interface representing subscribers reacting to order status changes.
 */
public interface OrderObserver {
    void update(Order order);
}
