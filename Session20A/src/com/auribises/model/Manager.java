package com.auribises.model;

public class Manager {

	Integer mid;
	String name;
	String phone;
	String email;
	
	Restaurant restaurant; // HAS-A Relationship | 1 to 1 Mapping
	
	public Manager() {
	
	}

	public Manager(Integer mid, String name, String phone, String email, Restaurant restaurant) {
		this.mid = mid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.restaurant = restaurant;
	}
	
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
