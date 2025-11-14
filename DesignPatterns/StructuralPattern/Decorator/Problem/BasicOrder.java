/**
 * Problem: Subclass explosion when trying to combine features via inheritance.
 * For example, to support GiftWrap + ExpressShipping + Discount combinations,
 * you would need many subclasses like GiftWrapExpressDiscountOrder etc.
 */
public class BasicOrder {
    private double basePrice;

    public BasicOrder(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getCost() {
        return basePrice;
    }

    public String getDescription() {
        return "Basic Order";
    }
}
