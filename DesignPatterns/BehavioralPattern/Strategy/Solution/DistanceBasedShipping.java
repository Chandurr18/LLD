package BehavioralPattern.Strategy.Solution;

/**
 * Distance-based shipping strategy.
 */
public class DistanceBasedShipping implements ShippingStrategy {
    @Override
    public double calculate(Order order) {
        return order.getDistanceKm() * 5;
    }
}
