package edu.jsp.store.controller;
import edu.jsp.store.model.Store;
import java.util.ArrayList;
import java.util.List;
import edu.jsp.store.model.Product;


public class Controller {
	public static Store store = null;
	public Store getStore()
	{
	 return store = new Store();
		
	}
	public void addProduct(Product product) {
		if(store.getProducts()==null) {
		store.setProducts(new ArrayList<Product>());
		List<Product> products =store.getProducts();
		products.add(product);
	}else {
		store.getProducts().add(product);
	}
	}
	public void addProducts(List<Product> newProducts) {


		if(store.getProducts()!= null) {
			for (Product product : newProducts) {
				addProduct(product);
			}
		}else {
			store.getProducts().addAll(newProducts);
			
		}
	}

	public List<Product> getAllProducts() {

		return store.getProducts();
		
		
	}
	
	
	public void removeProduct(List<Integer> products) {
		List<Product> existingProducts = store.getProducts();
		//to change target
		for (Integer productTarget : products) {
			//elimination target
			int targetId = productTarget;
			for (Product productEliminator : existingProducts) {
				if (productEliminator.getId() == targetId) {
					store.getProducts().remove(productEliminator);
					existingProducts.remove(productEliminator);
					
					}
				  }
				}
			  }
			}
	

