package edu.jasp.store.view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

import edu.jasp.store.controller.controller;
import edu.jasp.store.model.Product;
import edu.jasp.store.model.Store;

public class view {
	static Scanner myInput = new Scanner(System.in);
	static controller controller = new controller();
	static Store store = controller.getStore();
	static {
		System.out.println("------- Welcome to store --------");
		System.out.println("Enter id");
		store.setId(myInput.nextInt());
		myInput.nextLine();
		System.out.println("Enter name");
		store.setName(myInput.nextLine());
		System.out.println("Enter number");
		store.setContact(myInput.nextLong());
		myInput.nextLine();
		System.out.println("Enter Address");
		store.setAddress(myInput.nextLine());
		System.out.println();
		
	}
	
	public static void main(String[] args) {
	do {
		System.out.println("Select option from below list: ");
		System.out.println("1.Display store information\n2.Add product\n3.Display all product\n4.Update product\n5.Remove Product\n6.Add products\n7.Particular Product Details\n0.Exit");
		System.out.println("Enter digit respective to desired option: ");
		byte userChoice = myInput.nextByte();
		myInput.nextLine();
		switch(userChoice) {
		case 0: 
			System.out.println("- - - - Exited - - - -");
			System.exit(0);
			break;
		case 1:
			System.out.println("Store: "+store+"\n");
			break;
		case 2:
			controller.addProduct(getProductDetails());
			System.out.println(store.getProducts());
			break;
		case 3:
				diplayAllProducts();
			
			break;
		case 4:
				diplayAllProducts();
				System.out.print("Enter the id want to update: ");
				int productIdToUpdate = myInput.nextInt();
				myInput.nextLine();
				byte updateOption = myInput.nextByte();
				myInput.nextLine();
				switch(updateOption) {
				case 1:
					System.out.println("Enter name to update");
					String newName = myInput.nextLine();
					controller.updateProductName(productIdToUpdate, newName);
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
					default:
						System.out.print("------Invalid Selection------\n");
				}
			break;
		case 5:
				if(diplayAllProducts()) {
					boolean flag = true;
					ArrayList<Integer> productIdsToRemove = new ArrayList<Integer>();
					do {
						System.out.println("Enter product id to remove: ");
						int idToRemove = myInput.nextInt();
						myInput.nextLine();
						productIdsToRemove.add(idToRemove);
						System.out.println("Continue adding id to remove? y/n ");
						if(myInput.next().charAt(0)=='n') {
							flag = false;
						}
					}while(flag);
					controller.removeProduct(productIdsToRemove);
				}
			break;
		case 6:
			controller.addProducts(addProducts());
			System.out.println(store.getProducts());
			break;
		case 7:
			
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
	}while(true);
	
	}
	public static Product getProductDetails() {
		System.out.println("Enter id: ");
		int productId = myInput.nextInt();
		myInput.nextLine();
		System.out.println("Enter name: ");
		String productName = myInput.nextLine();
		System.out.println("Enter price: ");
		double productPrice = myInput.nextInt();
		myInput.nextLine();
		System.out.println("Enter Quantity: ");
		int productQuantity = myInput.nextInt();
		myInput.nextLine();
		boolean productAvailibility = true;
		if(productQuantity<=0) {
			productAvailibility = false;
		}
		return new Product(productId, productName, productPrice, productQuantity, productAvailibility);
	}
	
	public static List<Product> addProducts() {
		ArrayList<Product> newProductList = new ArrayList<Product>();
		boolean toContinue = true;
		do {
			newProductList.add(getProductDetails());
			System.out.println("Continue adding products ? y/n: ");
			if(myInput.next().charAt(0)=='n') 
				toContinue = false;
			}while(toContinue);
			return newProductList;
		}
	
	public static boolean diplayAllProducts() {
		// table header
		List<Product>allProducts = controller.getAllProduct();
		if(allProducts == null) {
			System.out.println("No products to display\n");
			return false;
		}else {
		System.out.printf("|%-5s|%-15s|%-11s|%-10s|%-12s|", "ID", "NAME", "PRICE", "QUANTITY", "AVAILABILITY");
		System.out.println();
		for (Product product : allProducts) {
			System.out.printf("|%-5d|", product.getId());
			System.out.printf("%-15s|", product.getName());
			System.out.printf("%-11f|", product.getPrice());
			System.out.printf("%-10d|", product.getQuantity());
			System.out.printf("%-12b|", product.getAvailibility());
			System.out.println();
			}
		return true;
		}
	}
}
