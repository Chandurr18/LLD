package com.lld.practice.VendingMachine.repository;

import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.model.InventoryItem;
import com.lld.practice.VendingMachine.model.Item;

import java.util.List;

public interface InventoryRepository {
    Item getItem(String code) throws ItemNotFoundException;
    void reduceStock(String code,int quantity);
    void addStock(String code, int quantity);
    int getStock(String code);
    boolean isAvailable(String code);
    void addItem(Item item, int quantity);
    List<InventoryItem> getCurrentItemsStock();
}
