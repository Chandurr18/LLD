package SOLIDPrinciples.OpenClosedPrinciple.Solution;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    public static void main(String[] args) {
        // Wire strategies (in real apps, a DI container / config would do this)
        Map<String, PaymentMethod> map = new HashMap<>();
        map.put("CREDIT_CARD", new CreditCardPayment());
        map.put("UPI", new UPIPayment());
        // Add new ones here *only in wiring/config*, not in service logic
        PaymentRegistry registry = new PaymentRegistry(map);

        PaymentService service = new PaymentService();

        // Direct strategy usage:
        service.process(new CreditCardPayment(), 1299.00);
        service.process(new UPIPayment(), 899.00);

        // Lookup by key (e.g., coming from API request / UI selection):
        service.process(registry.byKey("CREDIT_CARD"), 500.00);
    }
}
