package com.lld.practice.BookMyShow.strategy.payment;

import com.lld.practice.BookMyShow.model.Booking;

public class UpiPaymentStrategy implements  PaymentStrategy{
    @Override
    public boolean pay(Booking booking) {
        return true;
    }
}
