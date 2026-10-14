package com.lld.practice.ParkingLot.model;

import java.time.LocalDateTime;

import com.lld.practice.ParkingLot.enums.GateType;
import com.lld.practice.ParkingLot.enums.PaymentMode;
import com.lld.practice.ParkingLot.service.ParkingLot;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.EXIT;
    }

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        ParkingLot.INSTANCE.unparkVehicle(ticketId, exitTime, paymentMode);
    }
}
