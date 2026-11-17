package com.lld.practice.VendingMachine.state;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.enums.VendingStatus;
import com.lld.practice.VendingMachine.factory.VendingMachineStateFactory;

public class ItemSelectedState extends VendingMachineState{
    public ItemSelectedState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code, int quantity){
        System.out.println("Item already selected");
    }

    @Override
    public void insertCoin(Coin coin){
        vendingMachine.addBalance(coin.getValue());

        System.out.println("Coin inserted: " + coin.getValue());
        double price = vendingMachine.getSelectedItem().getPrice() * vendingMachine.getSelectedItemQuantity();

        if(vendingMachine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            VendingMachineState hasMoneyState = VendingMachineStateFactory.createState(VendingStatus.HAS_MONEY, vendingMachine);
            vendingMachine.setState(hasMoneyState);
        }
    }

    @Override
    public void dispense(){
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund(){
        vendingMachine.refundBalance();
        vendingMachine.reset();
    }
}
