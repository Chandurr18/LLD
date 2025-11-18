package BehavioralPattern.Strategy.Solution;

/**
 * Context class that uses different shipping strategies dynamically.
 */
public class ShippingService {
    private ShippingStrategy strategy;

    public ShippingService(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShipping(Order order) {
        return strategy.calculate(order);
    }
}
