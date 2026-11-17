package com.lld.practice.VendingMachine;

import com.lld.practice.VendingMachine.enums.Coin;
import com.lld.practice.VendingMachine.exceptions.ItemNotFoundException;
import com.lld.practice.VendingMachine.repository.InMemoryInventoryRepository;
import com.lld.practice.VendingMachine.repository.InventoryRepository;
import com.lld.practice.VendingMachine.service.InventoryService;

public class Main {
    public static void main(String[] args) throws ItemNotFoundException {
        InventoryRepository inventoryRepository = new InMemoryInventoryRepository();
        InventoryService inventoryService = new InventoryService(inventoryRepository);

        VendingMachine vendingMachine = new VendingMachine(inventoryService);

        // Add products to the inventory
        vendingMachine.addItem("A1", "Coke", 25, 3);
        vendingMachine.addItem("A2", "Pepsi", 25, 2);
        vendingMachine.addItem("B1", "Water", 10, 5);

        System.out.println();
        vendingMachine.printCurrentStock();

        // Select a product
        System.out.println("\n--- Step 1: Select an item ---");
        vendingMachine.selectItem("A1", 1);

        // Insert coins
        System.out.println("\n--- Step 2: Insert coins ---");
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.NICKEL); // 5

        // Dispense the product
        System.out.println("\n--- Step 3: Dispense item ---");
        vendingMachine.dispense(); // Should dispense Coke

        System.out.println();
        vendingMachine.printCurrentStock();

        // Select another item
        System.out.println("\n--- Step 4: Select another item ---");
        vendingMachine.selectItem("B1", 2);

        // Insert more amount
        System.out.println("\n--- Step 5: Insert more than needed ---");
        vendingMachine.insertCoin(Coin.QUARTER); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 6: Dispense and return change ---");
        vendingMachine.dispense();

        System.out.println();
        vendingMachine.printCurrentStock();

        // Select another item
        System.out.println("\n--- Step 7: Select another item ---");
        vendingMachine.selectItem("B1", 3);

        // Insert more amount
        System.out.println("\n--- Step 8: Insert more than needed ---");
        vendingMachine.insertCoin(Coin.QUARTER); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 9: Dispense and return change ---");
        vendingMachine.dispense();

        // Resetting for another scenario
        vendingMachine.reset();

        System.out.println();
        vendingMachine.printCurrentStock();

        // Select another item
        System.out.println("\n--- Step 10: Select another item, more than available quantity ---");
        vendingMachine.selectItem("A1", 3);

        System.out.println();
        vendingMachine.printCurrentStock();
    }
}
