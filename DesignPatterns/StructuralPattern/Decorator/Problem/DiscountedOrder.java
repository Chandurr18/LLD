/**
 * A naive subclass adding discount feature.
 */
public class DiscountedOrder extends BasicOrder {
    public DiscountedOrder(double basePrice) {
        super(basePrice);
    }

    @Override
    public double getCost() {
        return super.getCost() * 0.9; // 10% discount
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", 10% Discount";
    }
}
