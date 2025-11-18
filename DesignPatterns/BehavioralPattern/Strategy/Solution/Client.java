package BehavioralPattern.Strategy.Solution;

/**
 * Demonstrates selecting strategies at runtime.
 */
public class Client {
    public static void main(String[] args) {

        Order order = new Order(5.0, 100.0);

        ShippingService service = new ShippingService(new FlatRateShipping());
        System.out.println("Flat Rate: " + service.calculateShipping(order));

        service.setStrategy(new WeightBasedShipping());
        System.out.println("Weight Based: " + service.calculateShipping(order));

        service.setStrategy(new DistanceBasedShipping());
        System.out.println("Distance Based: " + service.calculateShipping(order));

        service.setStrategy(new ThirdPartyAPIBasedShipping());
        System.out.println("Third Party API: " + service.calculateShipping(order));
    }
}
