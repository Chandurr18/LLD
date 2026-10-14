package com.lld.practice.ParkingLot.factory;

import com.lld.practice.ParkingLot.enums.PaymentMode;
import com.lld.practice.ParkingLot.strategy.payment.CardPayment;
import com.lld.practice.ParkingLot.strategy.payment.CashPayment;
import com.lld.practice.ParkingLot.strategy.payment.PaymentStrategy;
import com.lld.practice.ParkingLot.strategy.payment.UpiPayment;

public class PaymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode mode) {
        return switch (mode) {
            case CASH -> new CashPayment();
            case UPI -> new UpiPayment();
            case CARD -> new CardPayment();
        };
    }
}