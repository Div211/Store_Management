package edu.jsp.Store_management.view;

import edu.jsp.Store_management.controller.Controller;
import edu.jsp.Store_management.model.Product;
import edu.jsp.Store_management.model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static Controller controller = new Controller();
    static Store store = controller.getStore();

    static {
        System.out.println("------- Welcome to the Store --------");
        System.out.println("Enter store ID:");
        store.setId(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter store name:");
        store.setName(scanner.nextLine());
        System.out.println("Enter store contact number:");
        store.setContact(scanner.nextLong());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter store address:");
        store.setAddress(scanner.nextLine());
    }

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Select an option from the list below:");
            System.out.println("1. Display store information");
            System.out.println("2. Add a product");
            System.out.println("3. Display all products");
            System.out.println("4. Update a product");
            System.out.println("5. Remove products");
            System.out.println("6. Add multiple products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            byte userChoice = scanner.nextByte();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 0:
                	System.out.println("Thanks for visting : ");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(store + "\n");
                    break;
                case 2:
                    controller.addProduct(getProductDetails());
                    break;
                case 3:
                    displayAllProducts();
                    break;
                case 4:
                    updateProductDetails();
                    break;
                case 5:
                    removeProducts();
                    break;
                case 6:
                    controller.addProducts(addProducts());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        System.out.println("Exiting the store management system.");
    }

    public static Product getProductDetails() {
        System.out.println("Enter product ID:");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        System.out.println("Enter product price:");
        double productPrice = scanner.nextDouble();
        System.out.println("Enter product quantity:");
        int productQuantity = scanner.nextInt();
        boolean productAvailability = productQuantity > 0;

        return new Product(productId, productName, productPrice, productQuantity, productAvailability);
    }

    public static List<Product> addProducts() {
        List<Product> newProductList = new ArrayList<>();
        boolean toContinue = true;
        while (toContinue) {
            newProductList.add(getProductDetails());
            System.out.println("Continue adding products? (y/n):");
            toContinue = scanner.next().charAt(0) == 'y';
        }
        return newProductList;
    }

    public static boolean displayAllProducts() {
        List<Product> allProducts = controller.getAllProducts();
        if (allProducts == null || allProducts.isEmpty()) {
            System.out.println("No products to display.");
            return false; // Return false when there are no products
        } else {
            System.out.printf("|%-5s|%-15s|%-11s|%-10s|%-12s|%n", "ID", "NAME", "PRICE", "QUANTITY", "AVAILABILITY");
            for (Product product : allProducts) {
                System.out.printf("|%-5d|%-15s|%-11.2f|%-10d|%-12b|%n",
                        product.getId(), product.getName(), product.getPrice(),
                        product.getQuantity(), product.isAvailability());
            }
            return true; // Return true when products are displayed
        }
    }

    public static void updateProductDetails() {
        displayAllProducts();
        System.out.println("Enter the ID of the product you want to update:");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product existingProduct = controller.getProductById(productId);
        if (existingProduct != null) {
            System.out.println("Enter new product details:");
            Product updatedProduct = getProductDetails();
            controller.updateProduct(productId, updatedProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void removeProducts() {
        if (displayAllProducts()) {
            List<Integer> productIdsToRemove = new ArrayList<>();
            boolean flag = true;
            while (flag) {
                System.out.println("Enter product ID to remove:");
                int idToRemove = scanner.nextInt();
                productIdsToRemove.add(idToRemove);
                System.out.println("Continue removing products? (y/n):");
                flag = scanner.next().charAt(0) == 'y';
            }
            controller.removeProducts(productIdsToRemove);
            System.out.println("Selected products removed successfully.");
        }
    }

    public static boolean displayAllProducts1() {
        List<Product> allProducts = controller.getAllProducts();
        if (allProducts == null || allProducts.isEmpty()) {
            System.out.println("No products to display.");
            return false;
        } else {
            System.out.printf("|%-5s|%-15s|%-11s|%-10s|%-12s|%n", "ID", "NAME", "PRICE", "QUANTITY", "AVAILABILITY");
            for (Product product : allProducts) {
                System.out.printf("|%-5d|%-15s|%-11.2f|%-10d|%-12b|%n",
                        product.getId(), product.getName(), product.getPrice(),
                        product.getQuantity(), product.isAvailability());
            }
            return true;
        }
    }
}