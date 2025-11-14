/**
 * Demonstrates the subclass explosion problem.
 */
public class Client {
    public static void main(String[] args) {
        BasicOrder o1 = new BasicOrder(1000.0);
        GiftWrappedOrder o2 = new GiftWrappedOrder(1000.0);
        ExpressShippingOrder o3 = new ExpressShippingOrder(1000.0);
        DiscountedOrder o4 = new DiscountedOrder(1000.0);

        System.out.println(o1.getDescription() + " -> ₹" + o1.getCost());
        System.out.println(o2.getDescription() + " -> ₹" + o2.getCost());
        System.out.println(o3.getDescription() + " -> ₹" + o3.getCost());
        System.out.println(o4.getDescription() + " -> ₹" + o4.getCost());

        // To represent GiftWrapped + Express + Discount we'd need another subclass - explosion
    }
}
