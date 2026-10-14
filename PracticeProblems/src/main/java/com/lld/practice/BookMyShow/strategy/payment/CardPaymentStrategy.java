package com.lld.practice.BookMyShow.strategy.payment;

import com.lld.practice.BookMyShow.model.Booking;

public class CardPaymentStrategy implements  PaymentStrategy{
    @Override
    public boolean pay(Booking booking) {
        return true;
    }
}
