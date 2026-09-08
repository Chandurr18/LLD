package model;

import java.time.LocalDateTime;

import enums.GateType;
import enums.PaymentMode;
import service.ParkingLot;

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
