package org.example;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {

    private HashMap<String, Integer> inventory;

    public InventorySystem() {

        this.inventory = new HashMap<>();

        this.inventory.put("Milk", 20);
        this.inventory.put("Bread", 15);
        this.inventory.put("Eggs", 30);

    }

    public boolean addProduct(String product, int quantity) {


        if(quantity > 0) {
            inventory.put(product, quantity);
            return true;
        }

        return false;
    }

    public int getQuantity(String product) {
        if (inventory.containsKey(product)) {
            return inventory.get(product);
        }
        return -1;
    }

    public boolean checkProduct(String product) {
        if (getQuantity(product) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateProduct(String product, int newQuantity) {
        if (!inventory.containsKey(product)) {
            System.out.println("Product not found.");
            return false;
        }
        if (newQuantity < 0) {
            System.out.println("New quantity cannot be negative.");
            return false;
        }
        inventory.put(product, newQuantity);
        System.out.println("Stock updated!");
        return true;
    }

    public boolean removeProduct(String product) {
        if (!inventory.containsKey(product)) {
            System.out.println("Product not found.");
            return false;
        }
        inventory.remove(product);
        System.out.println("Product removed.");
        return true;
    }

    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is currently empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " pcs");
        }
    }

}

