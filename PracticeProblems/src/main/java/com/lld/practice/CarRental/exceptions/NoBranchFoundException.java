package com.lld.practice.CarRental.exceptions;

public class NoBranchFoundException extends Throwable{
    public NoBranchFoundException(String message) {
        super(message);
    }
}
