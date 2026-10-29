package com.lld.practice.CarRental.strategy.payment;

import com.lld.practice.CarRental.model.Booking;

public class UPIPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(Booking booking) {
        System.out.println("Processing UPI payment for booking: " + booking);
        return true;
    }
}
