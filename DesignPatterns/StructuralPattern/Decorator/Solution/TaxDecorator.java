package DesignPatterns.StructuralPattern.Decorator.Solution;

/**
 * Concrete Decorator adding tax percentage (e.g., GST 18%).
 * Tax is applied on the cost returned by wrapped component.
 */
public class TaxDecorator extends OrderDecorator {
    private final double taxPercent;

    public TaxDecorator(Order order, double taxPercent) {
        super(order);
        this.taxPercent = taxPercent;
    }

    @Override
    public double getCost() {
        return super.getCost() * (1 + taxPercent / 100.0);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tax " + taxPercent + "%";
    }
}
