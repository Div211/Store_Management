package edu.jsp.store.view;

import edu.jsp.store.controller.Controller;
import edu.jsp.store.model.Product;
import edu.jsp.store.model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class View {
	static Scanner myInput = new Scanner(System.in);
	static Controller Controller = new Controller();
	static Store store = Controller.getStore();
	static {
		System.out.println("- - - -WELCOME TO STORE- - - -");
		System.out.println("Enter id: ");
		store.setId(myInput.nextInt());
		myInput.nextLine();
		System.out.print("Enter Store Name");
		store.setName(myInput.next());
		System.out.print("Enter Contact: ");
		store.setContact(myInput.nextLong());
		myInput.nextLine();
		System.out.print("Enter Address: ");
		store.setAddress(myInput.nextLine());
	
	}

	
	public static void main(String[] args) {
	boolean flag=true;
	do {
		System.out.println("Select the option from below list: ");
		System.out.println("1. Display store information\n2. Add product\n3. Display all product\n4. Update product\n5. Remove Product\n6. Add Products \n7.Display Product \n0. Exit ");
		System.out.println("Enter the Your Digit Choice Respectively: ");
		byte userChoice = myInput.nextByte();
		myInput.nextLine();
		switch(userChoice) {
		case 0: 
			System.out.println("======EXITED======");
			System.exit(0);//terminates the program
			
			break;
	case 1:
			System.out.println(store);
			
			break;
	case 2:
			Controller.addProduct(getProductDetails());
			System.out.println(store.getProducts());
			break;
	case 3:
			displayAllProducts();
			break;
	case 4:
			displayAllProducts();
			break;
	case 5:
			if(displayAllProducts()) {
				boolean flag1 = true;
				ArrayList<Integer> productIdsToRemove = new ArrayList<Integer>();
				do {
					System.out.println("Enter product Id");
					int idToRemove = myInput.nextInt();
					myInput.nextLine();
					productIdsToRemove.add(idToRemove);
					System.out.println("Continue adding id to remove? y/n: ");
					if(myInput.next().charAt(0) == 'n') {
						flag1=false;
					}
				}while(flag1);
				Controller.removeProduct(productIdsToRemove);
			}
			break;
	case 6:
			
			Controller.addProducts(addProducts());
			System.out.println(store.getProducts());
			break;
		case 7: 
			
			
			default:
				System.out.println("Invalid Choice");
				
		}
		}while(true);
	
	}

	public static Product getProductDetails() {   
	System.out.println("Enter ID: ");
	int productId = myInput.nextInt();
	myInput.nextLine();
	System.out.println("Enter Name: ");
	String productName = myInput.nextLine();
	myInput.nextLine();
	System.out.println("Enter Price: ");
	double productPrice = myInput.nextDouble();
	myInput.nextLine();
	System.out.println("Enter Quantity: ");
	int productQuantity = myInput.nextInt();
	myInput.nextLine();
	boolean productAvailability = true;
	if( productQuantity <=0) {
		productAvailability = false;
		
	}
	return new Product(productId, productName, productPrice, productQuantity, productAvailability);
	}

	public static List<Product> addProducts(){
		ArrayList<Product> newProductList = new ArrayList<Product>();
		boolean toContinue = true;
		do {
			newProductList.add(getProductDetails());
			System.out.println("Continue adding products? y/n: ");
			if(myInput.next().charAt(0) == 'n')
				toContinue= false;
			}while (toContinue);
		return newProductList;
	}

	
	public static boolean displayAllProducts() {
	    // Table Header
		List<Product> allProducts = Controller.getAllProducts();
		if(allProducts == null) {
			System.out.println("No products to display!\n");
			return false;
			
		} else {
        System.out.printf("|%-5s|%-10s|%-10s|%-10s|%-15s|%n", "ID", "NAME", "PRICE", "QUANTITY", "AVAILABILITY");

        // Table Row Divider
        System.out.println("|-----|----------|----------|----------|---------------|");

        // Table Content
        for (Product product : allProducts) {
            System.out.printf("%-5d|", product.getId());
            System.out.printf("%-15s|", product.getName());
            System.out.printf("%-10f|",product.getPrice());
            System.out.printf("%-10d|",product.getQuantity());
            System.out.printf("%-15b|%n",product.isAvailability());
		
		}
        return true;
	}
  }
	
}
