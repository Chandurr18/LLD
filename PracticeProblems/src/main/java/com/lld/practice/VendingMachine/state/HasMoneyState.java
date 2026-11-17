package com.lld.practice.VendingMachine.state;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.enums.VendingStatus;
import com.lld.practice.VendingMachine.factory.VendingMachineStateFactory;

public class HasMoneyState extends VendingMachineState{
    public HasMoneyState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code, int quantity){
        System.out.println("Item already selected.");
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Already received full amount.");
    }

    @Override
    public void dispense(){
        VendingMachineState dispenseState = VendingMachineStateFactory.createState(VendingStatus.DISPENSE, vendingMachine);
        vendingMachine.setState(dispenseState);
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund(){
        vendingMachine.refundBalance();
        vendingMachine.reset();

        VendingMachineState idleState = VendingMachineStateFactory.createState(VendingStatus.IDLE, vendingMachine);
        vendingMachine.setState(idleState);
    }
}
