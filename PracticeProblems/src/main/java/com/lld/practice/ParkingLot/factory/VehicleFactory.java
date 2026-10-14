package com.lld.practice.ParkingLot.factory;

import com.lld.practice.ParkingLot.enums.VehicleType;
import com.lld.practice.ParkingLot.model.Bike;
import com.lld.practice.ParkingLot.model.Car;
import com.lld.practice.ParkingLot.model.Truck;
import com.lld.practice.ParkingLot.model.Vehicle;

public class VehicleFactory {
    public static Vehicle create(String number, VehicleType type) {
        return switch (type) {
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);
        };
    }
}
