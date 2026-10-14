package com.lld.practice.BookMyShow.strategy.payment;

import com.lld.practice.BookMyShow.enums.PaymentType;

public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(PaymentType paymentType) {
        return switch (paymentType) {
            case CARD -> new CardPaymentStrategy();
            case UPI -> new UpiPaymentStrategy();
        };
    }
}
