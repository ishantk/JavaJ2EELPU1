package com.auribises.model;

public class FoodItem {

	// Attributes
	Integer itemCode;
	String name;
	Integer price;
	
	public FoodItem() {
		
	}
	
	public FoodItem(Integer itemCode, String name, Integer price) {
		this.itemCode = itemCode;
		this.name = name;
		this.price = price;
	}

	public Integer getItemCode() {
		return itemCode;
	}

	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [itemCode=" + itemCode + ", name=" + name + ", price=" + price + "]";
	}
	
}
