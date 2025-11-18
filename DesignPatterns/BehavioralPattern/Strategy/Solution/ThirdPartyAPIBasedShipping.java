package BehavioralPattern.Strategy.Solution;

/**
 * Third-party API shipping strategy (simulated).
 */
public class ThirdPartyAPIBasedShipping implements ShippingStrategy {
    @Override
    public double calculate(Order order) {
        System.out.println("[ThirdPartyAPI] Fetching live rate...");
        return 120.0;
    }
}
