package edu.jsp.store.model;

import java.util.List;

public class Store {
	private int id;
	private String Name;
	private long Contact;
	private String Address;

	private List<Product> products;

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getContact() {
		return Contact;
	}

	public void setContact(long contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", Name=" + Name + ", Contact=" + Contact + ", Address=" + Address + "]";
	}

}
