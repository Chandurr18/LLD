package com.lld.practice.VendingMachine.state;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;

public abstract class VendingMachineState {
    protected final VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public abstract void selectItem(String code, int quantity) throws ItemNotFoundException;
    public abstract  void insertCoin(Coin coin);
    public abstract void dispense();
    public abstract void refund();
}
