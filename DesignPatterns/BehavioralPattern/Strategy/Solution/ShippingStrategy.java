package BehavioralPattern.Strategy.Solution;

/**
 * Strategy interface for different shipping algorithms.
 */
public interface ShippingStrategy {
    double calculate(Order order);
}
