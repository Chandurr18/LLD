package com.lld.practice.CarRental.strategy.payment;

import com.lld.practice.CarRental.model.Booking;

public interface PaymentStrategy {
    boolean processPayment(Booking booking);
}
