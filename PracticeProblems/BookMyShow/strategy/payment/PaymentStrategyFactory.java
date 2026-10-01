package strategy.payment;

import enums.PaymentType;

public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case CARD -> new CardPaymentStrategy();
            case UPI -> new UpiPaymentStrategy();
        };
    }
}
