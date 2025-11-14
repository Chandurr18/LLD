package DesignPatterns.StructuralPattern.Decorator.Solution;

/**
 * Concrete Decorator adding gift wrap cost.
 */
public class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Gift Wrapped";
    }
}
