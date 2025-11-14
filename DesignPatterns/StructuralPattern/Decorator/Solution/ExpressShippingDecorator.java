package DesignPatterns.StructuralPattern.Decorator.Solution;

/**
 * Concrete Decorator adding express shipping cost.
 */
public class ExpressShippingDecorator extends OrderDecorator {
    public ExpressShippingDecorator(Order order) {
        super(order);
    }

    @Override
    public double getCost() {
        return super.getCost() + 150.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Express Shipping";
    }
}
