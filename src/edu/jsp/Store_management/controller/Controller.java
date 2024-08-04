package edu.jsp.Store_management.controller;

import edu.jsp.Store_management.model.Product;
import edu.jsp.Store_management.model.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {
    private Store store;

    public Controller() {
        this.store = new Store();
    }

    public Store getStore() {
        return store;
    }

    public void addProduct(Product product) {
        if (store.getProducts() == null) {
            store.setProducts(new ArrayList<>());
        }
        store.getProducts().add(product);
    }

    public void addProducts(List<Product> newProducts) {
        if (store.getProducts() == null) {
            store.setProducts(new ArrayList<>());
        }
        store.getProducts().addAll(newProducts);
    }

    public List<Product> getAllProducts() {
        return store.getProducts();
    }

    public void removeProducts(List<Integer> productIds) {
        List<Product> products = store.getProducts();
        if (products != null) {
            products.removeIf(product -> productIds.contains(product.getId()));
        }
    }

    public void updateProduct(int productId, Product updatedProduct) {
        List<Product> products = store.getProducts();
        if (products != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == productId) {
                    products.set(i, updatedProduct);
                    break;
                }
            }
        }
    }

    public Product getProductById(int productId) {
        List<Product> products = store.getProducts();
        if (products != null) {
            for (Product product : products) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }
        return null;
    }
}