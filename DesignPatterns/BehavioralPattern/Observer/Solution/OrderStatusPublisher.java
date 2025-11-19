package DesignPatterns.BehavioralPattern.Observer.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject (Observable) that manages observers and notifies them on order status updates.
 */
public class OrderStatusPublisher {

    private final List<OrderObserver> observers = new ArrayList<>();

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }
}
