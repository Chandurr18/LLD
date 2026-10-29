package com.lld.practice.CarRental.service;

import com.lld.practice.CarRental.enums.PaymentStatus;
import com.lld.practice.CarRental.model.Booking;
import com.lld.practice.CarRental.strategy.payment.PaymentStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentProcessor {
    private final PaymentStrategy paymentStrategy;

    public boolean pay(Booking booking) {
        boolean success = paymentStrategy.processPayment(booking);

        if(success) {
            booking.setPaymentStatus(PaymentStatus.SUCCESS);
        } else {
            booking.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Payment Failed");
        }

        return success;
    }
}
