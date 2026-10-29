package com.lld.practice.CarRental.exceptions;

public class BookingNotFoundException extends Throwable{
    public BookingNotFoundException(String message) {
        super(message);
    }
}
