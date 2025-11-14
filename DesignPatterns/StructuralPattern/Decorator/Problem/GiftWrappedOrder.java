/**
 * A naive subclass adding gift wrap feature.
 */
public class GiftWrappedOrder extends BasicOrder {
    public GiftWrappedOrder(double basePrice) {
        super(basePrice);
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
