package factory;

import enums.PaymentMode;
import strategy.payment.CardPayment;
import strategy.payment.CashPayment;
import strategy.payment.PaymentStrategy;
import strategy.payment.UpiPayment;

public class PaymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode mode) {
        return switch (mode) {
            case CASH -> new CashPayment();
            case UPI -> new UpiPayment();
            case CARD -> new CardPayment();
        };
    }
}