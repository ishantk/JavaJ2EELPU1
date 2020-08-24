package com.auribises.beans;

public class Pizza extends FoodItem { // IS-A Relationship

	int size;
	String description;
	
	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public Pizza(int size, String description) {
		this.size = size;
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Pizza [size=" + size + ", description=" + description + ", name=" + name + ", price=" + price + "]";
	}
	
}
