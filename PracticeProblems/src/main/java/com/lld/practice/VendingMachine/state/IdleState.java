package com.lld.practice.VendingMachine.state;

import com.lld.practice.VendingMachine.VendingMachine;
import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.enums.VendingStatus;
import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.factory.VendingMachineStateFactory;
import com.lld.practice.VendingMachine.model.Item;

public class IdleState extends VendingMachineState{
    public IdleState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void selectItem(String code, int quantity) throws ItemNotFoundException {
        if(!vendingMachine.getInventoryService().isAvailable(code)){
            System.out.println("Item not available");
            return;
        }
        int currentStock = vendingMachine.getInventoryService().getStock(code);
        if(currentStock < quantity){
            System.out.println("Not available enough stock");
            return;
        }

        Item item = vendingMachine.getInventoryService().getItem(code);
        vendingMachine.setSelectedItem(item);
        vendingMachine.setSelectedItemQuantity(quantity);

        VendingMachineState itemSelectedState = VendingMachineStateFactory.createState(VendingStatus.ITEM_SELECTED, vendingMachine);
        vendingMachine.setState(itemSelectedState);

        System.out.println("Item selected: " + code + " , quantity: " + quantity);
    }

    @Override
    public void insertCoin(Coin coin){
        System.out.println("Please select an item before inserting money.");
    }

    @Override
    public void dispense(){
        System.out.println("No item selected.");
    }

    @Override
    public void refund(){
        System.out.println("No money to refund.");
    }
}
