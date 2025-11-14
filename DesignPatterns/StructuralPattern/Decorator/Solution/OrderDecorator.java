package DesignPatterns.StructuralPattern.Decorator.Solution;

/**
 * Abstract Decorator that wraps an Order.
 */
public abstract class OrderDecorator implements Order {
    protected final Order order;

    protected OrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public double getCost() {
        return order.getCost();
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }
}
