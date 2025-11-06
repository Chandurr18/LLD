package SOLIDPrinciples.OpenClosedPrinciple.Solution;

import java.util.Map;

/**
 * Registry allows lookup by key without if/else.
 * New methods register via configuration/wiring, not by editing code here.
 */
public class PaymentRegistry {
    private final Map<String, PaymentMethod> methods;
    public PaymentRegistry(Map<String, PaymentMethod> methods) {
        this.methods = methods;
    }
    public PaymentMethod byKey(String key) {
        PaymentMethod m = methods.get(key);
        if (m == null) throw new IllegalArgumentException("Unknown method: " + key);
        return m;
    }
}
