
package com.lld.practice.VendingMachine;

import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.enums.VendingStatus;
import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.factory.VendingMachineStateFactory;
import com.lld.practice.VendingMachine.model.Item;
import com.lld.practice.VendingMachine.service.InventoryService;
import com.lld.practice.VendingMachine.state.VendingMachineState;
import lombok.Getter;
import lombok.Setter;

@Getter
public class VendingMachine {
    @Setter
    private VendingMachineState state;

    private int balance;

    @Setter
    private Item selectedItem;

    @Setter
    private int selectedItemQuantity;


    private final InventoryService inventoryService;

    public VendingMachine(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.state = VendingMachineStateFactory.createState(
                VendingStatus.IDLE, this
        );
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(coin);
    }

    public void addItem(String code, String name, int price, int quantity) {
        inventoryService.addItem(code, name, price, quantity);
    }

    public void selectItem(String code, int quantity) throws ItemNotFoundException {
        state.selectItem(code, quantity);
    }

    public void dispense() {
        state.dispense();
    }

    public void dispenseItem() {
        int totalPrice = selectedItem.getPrice() * selectedItemQuantity;
        if (balance >= totalPrice) {
            inventoryService.reduceStock(
                    selectedItem.getCode(), selectedItemQuantity
            );

            balance -= totalPrice;

            System.out.println("Dispensed: " + selectedItem.getName() + " ,quantity: " + selectedItemQuantity);

            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }

        reset();
        setState(VendingMachineStateFactory.createState(
                VendingStatus.IDLE, this
        ));
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        this.balance = 0;
    }

    public void reset() {
        setState(VendingMachineStateFactory.createState(
                VendingStatus.IDLE, this
        ));
        this.selectedItem = null;
        this.balance = 0;
        this.selectedItemQuantity = 0;
    }

    public void addBalance(int value) {
        this.balance += value;
    }

    public void printCurrentStock(){
        inventoryService.printCurrentStock();
    }
}
