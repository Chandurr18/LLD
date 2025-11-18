package BehavioralPattern.Strategy.Solution;

/**
 * Weight-based shipping strategy.
 */
public class WeightBasedShipping implements ShippingStrategy {
    @Override
    public double calculate(Order order) {
        return order.getWeightKg() * 10;
    }
}
