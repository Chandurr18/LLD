package com.lld.practice.VendingMachine.model;

import lombok.Getter;

@Getter
public class InventoryItem {
    private final Item item;
    private int quantity;

    public InventoryItem(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public boolean isAvailable(){
        return quantity > 0;
    }

    public void increaseStock(int quantity){
        this.quantity += quantity;
    }

    public void decreaseStock(int quantity){
        this.quantity -= quantity;
    }
}
