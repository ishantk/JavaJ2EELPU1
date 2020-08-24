package com.auribises.model;

import java.util.List;

// Model or Bean or POJO
public class Restaurant {
	
	// Attributes
	Integer rid;
	String name;
	String type;
	Double ratings;
	String operatingHours;
	
	List<FoodItem> items; // HAS-A Relationship | 1 to many :)

	public Restaurant() {
		
	}
	
	public Restaurant(Integer rid, String name, String type, Double ratings, String operatingHours,
			List<FoodItem> items) {
		this.rid = rid;
		this.name = name;
		this.type = type;
		this.ratings = ratings;
		this.operatingHours = operatingHours;
		this.items = items;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	public void showRestaurant() {
		System.out.println("====================");
		
		System.out.println(name+" ["+ratings+"]");
		System.out.println(type+" | "+operatingHours);
		
		System.out.println("FoodItems: ");
		items.forEach((item) -> System.out.println(item));
		
		
		System.out.println("====================");
	}

	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", name=" + name + ", type=" + type + ", ratings=" + ratings
				+ ", operatingHours=" + operatingHours + ", items=" + items + "]";
	}
	

}
