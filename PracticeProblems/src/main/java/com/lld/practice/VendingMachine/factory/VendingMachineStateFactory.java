package com.lld.practice.VendingMachine.factory;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.VendingStatus;
import com.lld.practice.VendingMachine.state.*;

public class VendingMachineStateFactory {
    public static VendingMachineState createState(VendingStatus vendingStatus, VendingMachine vendingMachine) {
        return switch (vendingStatus){
            case DISPENSE -> new DispenseState(vendingMachine);
            case HAS_MONEY -> new HasMoneyState(vendingMachine);
            case ITEM_SELECTED -> new ItemSelectedState(vendingMachine);
            default -> new IdleState(vendingMachine);
        };
    }
}
