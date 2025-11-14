package StructuralPattern.Decorator.Solution;

/**
 * Concrete Component: base order implementation.
 */
public class BasicOrder implements Order {
    private final double basePrice;

    public BasicOrder(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getCost() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Basic Order";
    }
}
