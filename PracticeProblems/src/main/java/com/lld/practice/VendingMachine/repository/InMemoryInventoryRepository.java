package com.lld.practice.VendingMachine.repository;

import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.model.InventoryItem;
import com.lld.practice.VendingMachine.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryInventoryRepository implements InventoryRepository {
    private final Map<String, InventoryItem> inventory = new HashMap<>();

    @Override
    public Item getItem(String code) throws ItemNotFoundException {
        InventoryItem inventoryItem = inventory.get(code);
        if (inventoryItem == null) {
            throw new ItemNotFoundException(
                    "Item not found: " + code
            );
        }
        return inventoryItem.getItem();
    }

    @Override
    public void reduceStock(String code, int quantity) {
        InventoryItem inventoryItem = inventory.get(code);
        inventoryItem.decreaseStock(quantity);
    }

    @Override
    public void addStock(String code, int quantity) {
        InventoryItem inventoryItem = inventory.get(code);
        inventoryItem.increaseStock(quantity);
    }

    @Override
    public int getStock(String code) {
        InventoryItem inventoryItem = inventory.get(code);
        return inventoryItem.getQuantity();
    }

    @Override
    public boolean isAvailable(String code) {
        InventoryItem inventoryItem = inventory.get(code);
        return inventoryItem.isAvailable();
    }

    @Override
    public void addItem(Item item, int quantity) {
        InventoryItem inventoryItem = new InventoryItem(item, quantity);
        inventory.put(item.getCode(), inventoryItem);
    }

    @Override
    public List<InventoryItem> getCurrentItemsStock() {
        return new ArrayList<>(inventory.values());
    }
}
