/**
 * ❌ Problem:
 * Hardcoded shipping cost calculation logic using giant if-else.
 * Violates OCP and SRP.
 */
public class ShippingCalculator {

    public double calculateShippingCost(Order order, String shippingType) {

        if (shippingType.equals("FLAT_RATE")) {
            System.out.println("[ShippingCalculator] Applying FLAT RATE shipping");
            return 50.0;
        }
        else if (shippingType.equals("WEIGHT_BASED")) {
            System.out.println("[ShippingCalculator] Applying WEIGHT-BASED shipping");
            return order.getWeightKg() * 10;
        }
        else if (shippingType.equals("DISTANCE_BASED")) {
            System.out.println("[ShippingCalculator] Applying DISTANCE-BASED shipping");
            return order.getDistanceKm() * 5;
        }
        else if (shippingType.equals("THIRD_PARTY_API")) {
            System.out.println("[ShippingCalculator] Calling slow third-party API...");
            return 120.0; // fake response
        }

        System.out.println("[ShippingCalculator] Unknown shipping type. Returning 0.");
        return 0;
    }
}
