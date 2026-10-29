package com.lld.practice.CarRental.exceptions;

public class NoVehiclesFoundException extends Throwable{
    public NoVehiclesFoundException(String message) {
        super(message);
    }
}
