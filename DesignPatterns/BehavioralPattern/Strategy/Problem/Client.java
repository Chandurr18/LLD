/**
 * Demonstrates the PROBLEM version with tightly coupled logic.
 */
public class Client {
    public static void main(String[] args) {
        Order order = new Order(5.0, 100.0);
        ShippingCalculator calc = new ShippingCalculator();

        System.out.println("FLAT: " + calc.calculateShippingCost(order, "FLAT_RATE"));
        System.out.println("WEIGHT: " + calc.calculateShippingCost(order, "WEIGHT_BASED"));
        System.out.println("DISTANCE: " + calc.calculateShippingCost(order, "DISTANCE_BASED"));
        System.out.println("API: " + calc.calculateShippingCost(order, "THIRD_PARTY_API"));
    }
}
