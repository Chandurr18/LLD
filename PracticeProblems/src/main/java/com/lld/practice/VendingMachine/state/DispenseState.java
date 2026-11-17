package com.lld.practice.VendingMachine.state;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.Coin;

public class DispenseState extends VendingMachineState{
    public DispenseState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code, int quantity){
        System.out.println("Currently dispensing. Please Wait.");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Currently dispensing. Please Wait.");
    }

    @Override
    public void dispense(){
        // already triggered by HasMoneyState
    }

    @Override
    public void refund(){
        System.out.println("Currently dispensing. Please Wait.");
    }
}
