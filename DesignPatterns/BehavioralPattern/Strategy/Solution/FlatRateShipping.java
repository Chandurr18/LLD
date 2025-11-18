package BehavioralPattern.Strategy.Solution;

/**
 * Flat rate shipping strategy.
 */
public class FlatRateShipping implements ShippingStrategy {
    @Override
    public double calculate(Order order) {
        return 50.0;
    }
}
