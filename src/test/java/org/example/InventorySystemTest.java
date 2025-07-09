package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {

    InventorySystem testInventory;

    @BeforeEach
    void setup() {
        testInventory = new InventorySystem();
    }

    @Test
    void shouldAddNewProductWithValidQuantity() {

        String productName = "Banana";
        int quantityProduct = 30;

        boolean testProduct = testInventory.addProduct(productName, quantityProduct);

        assertTrue(testProduct);
        assertEquals(quantityProduct, testInventory.getQuantity(productName));
    }

    @Test
    void testAddingNewProductWithQuantityZero() {

        String productName = "Mango";
        int quantityProduct = 0;

        boolean testProduct = testInventory.addProduct(productName, quantityProduct);

        assertFalse(testProduct);
        assertEquals(-1, testInventory.getQuantity(productName));
        System.out.println("Failed to add product: Quantity must be greater than 0.");
    }

    @Test
    void shouldAddProductThatExists() {

        String productName = "Milk";
        int quantityProduct = 50;

        boolean testProduct = testInventory.addProduct(productName, quantityProduct);

        assertTrue(testProduct);
        assertEquals(quantityProduct, testInventory.getQuantity(productName));
    }

    @Test
    void shouldCheckExistingProduct() {

        String productName = "Milk";
        int quantityProduct = 20;

        boolean testCheckProduct = testInventory.checkProduct(productName);

        assertTrue(testCheckProduct);
        assertEquals(quantityProduct, testInventory.getQuantity(productName));
        System.out.println(productName + " is in stock: " + quantityProduct);
    }

    @Test
    void testCheckingNonExistingProduct() {

        String productName = "Ice Cream";

        boolean testCheckProduct = testInventory.checkProduct(productName);

        assertFalse(testCheckProduct);
        System.out.println("Product not found.");
    }

    @Test
    void shouldUpdateExistingProductWithValidQuantity() {

        String productName = "Bread";
        int newQuantityProduct = 25;

        boolean testUpdateProduct = testInventory.updateProduct(productName, newQuantityProduct);

        assertTrue(testUpdateProduct);
        assertEquals(newQuantityProduct, testInventory.getQuantity(productName));
    }

    @Test
    void testUpdatingNonExistingProduct() {

        String productName = "Tofu";
        int newQuantityProduct = 25;

        boolean testUpdateProduct = testInventory.updateProduct(productName, newQuantityProduct);

        assertFalse(testUpdateProduct);
    }

    @Test
    void shouldRemoveExistingProduct() {

        String productName = "Eggs";

        boolean testRemoveProduct = testInventory.removeProduct(productName);

        assertTrue(testRemoveProduct);
        assertEquals(-1, testInventory.getQuantity(productName));
    }

    @Test
    void testRemovingNonExistingProduct() {

        String productName = "Pizza";

        boolean testRemoveProduct = testInventory.removeProduct(productName);

        assertFalse(testRemoveProduct);
    }
}