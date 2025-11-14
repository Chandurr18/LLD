/**
 * A naive subclass adding express shipping feature.
 */
public class ExpressShippingOrder extends BasicOrder {
    public ExpressShippingOrder(double basePrice) {
        super(basePrice);
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
