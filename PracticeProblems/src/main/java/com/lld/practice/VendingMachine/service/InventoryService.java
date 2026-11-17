package com.lld.practice.VendingMachine.service;

import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.model.InventoryItem;
import com.lld.practice.VendingMachine.model.Item;
import com.lld.practice.VendingMachine.repository.InventoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Item getItem(String code) throws ItemNotFoundException {
        return inventoryRepository.getItem(code);
    }

    public boolean isAvailable(String code){
        return inventoryRepository.isAvailable(code);
    }

    public void reduceStock(String code, int quantity){
        int availableQuantity = inventoryRepository.getStock(code);

        if(availableQuantity < quantity){
            throw new RuntimeException("Not Enough Stock to reduce");
        }

        inventoryRepository.reduceStock(code, quantity);
    }

    public void addStock(String code, int quantity){
        inventoryRepository.addStock(code, quantity);
    }

    public void addItem(String code, String name, int price, int quantity){
        Item item = new Item(name, code, price);
        inventoryRepository.addItem(item, quantity);
    }

    public void printCurrentStock(){
        System.out.println("--- CURRENT STOCK ---");
        List<InventoryItem> stock = inventoryRepository.getCurrentItemsStock();
        for(InventoryItem item : stock){
            System.out.println(item.getItem().getName() + "($" + item.getItem().getPrice() + ")" + " - " + item.getItem().getCode() + " : " + item.getQuantity());
        }
    }

    public int getStock(String code){
        return inventoryRepository.getStock(code);
    }
}
