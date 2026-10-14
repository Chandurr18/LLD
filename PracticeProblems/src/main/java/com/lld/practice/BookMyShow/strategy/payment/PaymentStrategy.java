package com.lld.practice.BookMyShow.strategy.payment;

import com.lld.practice.BookMyShow.model.Booking;

public interface PaymentStrategy {
    boolean pay(Booking booking);
}
