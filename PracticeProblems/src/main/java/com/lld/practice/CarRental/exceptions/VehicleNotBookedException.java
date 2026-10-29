package com.lld.practice.CarRental.exceptions;

public class VehicleNotBookedException extends Throwable{
    public VehicleNotBookedException(String message) {
        super(message);
    }
}
