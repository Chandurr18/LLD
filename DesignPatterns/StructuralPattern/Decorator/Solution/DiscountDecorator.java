package StructuralPattern.Decorator.Solution;

/**
 * Concrete Decorator applying a percentage discount.
 * Note: discount is applied to the cost returned by wrapped component.
 */
public class DiscountDecorator extends OrderDecorator {
    private final double percent; // e.g., 10 for 10%

    public DiscountDecorator(Order order, double percent) {
        super(order);
        this.percent = percent;
    }

    @Override
    public double getCost() {
        return super.getCost() * (1 - percent / 100.0);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + percent + "% Discount Applied";
    }
}
