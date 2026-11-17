package com.lld.practice.VendingMachine.exceptions;

public class ItemNotFoundException extends Throwable{
    public ItemNotFoundException(String message){
        super(message);
    }
}
