package DesignPatterns.StructuralPattern.Adapter.Solution;
import java.util.Objects;

/**
 * PaymentProcessor demonstrates usage of PaymentGateway abstraction.
 * The processor is completely decoupled from third-party SDKs.
 */
public class PaymentProcessor {

    private final PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public void checkout(double amount) {
        System.out.println("[PaymentProcessor] Checkout amount: " + amount);
        gateway.pay(amount);
    }
}