package com.lld.practice.ParkingLot.strategy.payment;

import com.lld.practice.ParkingLot.model.Ticket;

public interface PaymentStrategy {
    boolean processPayment(Ticket ticket, double amount);
}