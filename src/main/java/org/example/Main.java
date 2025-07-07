package org.example;

import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InventorySystem inventoryManager = new InventorySystem();
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while(response != 6) {

            menuSystem();

            response = scanner.nextInt();
            scanner.nextLine();

            switch(response) {

                case 1:
                    inventoryManager.viewInventory();
                    break;
                case 2:
                    System.out.printf("Enter product name: ");
                    String productAdded = scanner.nextLine();

                    if (inventoryManager.getQuantity(productAdded) != -1) {
                        System.out.println("Product '" + productAdded + "' already exists.");
                        break;
                    }

                    System.out.printf("Enter quantity: ");
                    int amountOfProduct;
                    try {
                        amountOfProduct = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a whole number.");
                        break;
                    }

                    if (inventoryManager.addProduct(productAdded, amountOfProduct)) {
                        System.out.println("Product added!");
                    } else {
                        System.out.println("Failed to add product: Quantity must be greater than 0.");
                    }
                    break;
                case 3:
                    System.out.printf("Enter product name to check: ");
                    String productCheck = scanner.nextLine();

                    int quantityInStock = inventoryManager.getQuantity(productCheck); // Call getQuantity to get the amount

                    if (quantityInStock != -1) {
                        System.out.println(productCheck + " is in stock: " + quantityInStock);
                    } else {
                        System.out.println("Product '" + productCheck + "' not found in inventory.");
                    }
                    break;
                case 4:
                    System.out.printf("Enter product name to update: ");
                    String productToUpdate = scanner.nextLine();

                    System.out.printf("Enter new stock quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    inventoryManager.updateProduct(productToUpdate, newQuantity);

                    System.out.println("Stock updated!");
                    break;
                case 5:
                    System.out.printf("Enter product name to remove: ");
                    String productToRemove = scanner.nextLine();

                    inventoryManager.removeProduct(productToRemove);
                    break;
            }
        }

        System.out.println("Exiting system...");

    }
    public static void menuSystem() {
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Product");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");

        System.out.printf("Choose an option: ");
    }

}