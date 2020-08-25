package com.auribises.beans;

import java.util.Date;

public class Product {

	int stock;
	int id;
	String name;
	String description;
	int price;
	
	boolean active = true;
	
	// We may have some Order Object linked here :)
	boolean transaction = false;
	
	public Product() {
		
	}
	
	public Product(int stock, int id, String name, String description, int price) {
		this.stock = stock;
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// Method with Business Logic
	// In case we have pre-processing and post processing logic with our core logic, we must break it :)
	public void purchaseProduct(String where, String when) {
		
		if(active) {
			// 2. Process Payment and Generate an Order
			//    contact some Payment Gateway, and if transaction is successful
			//	  write the Order Object and save the details in DataBase
			System.out.println("[CORE-LOGIC] - Transaction");
			System.out.println();
			System.out.println("Please Process Your Payment for \u20b9"+price);
			System.out.println("Your Order Created with ID: "+new Date().toString());
			System.out.println("Thank You, for the Purchase of "+name);
			transaction = true; // as transaction is successful
			System.out.println();
		}else {
			System.out.println("Sorry ! Product is not active. Its OUT OF STOCK !! Please come back soon and check it :)");
		}
		
	}

	@Override
	public String toString() {
		return "Product [stock=" + stock + ", id=" + id + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}
	
}
