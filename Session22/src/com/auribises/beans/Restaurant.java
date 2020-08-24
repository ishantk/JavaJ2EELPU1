package com.auribises.beans;

import java.util.List;

public class Restaurant {
	
	String name;
	String phone;
	String address;
	
	// Dependency
	// if we wish to create Restaurant Object, FoodItem object must be related to it
	FoodItem item; 				// 1 to 1 mapping :)
	
	List<String> departments;	// 1 to many mapping :)
	
	public Restaurant() {
		System.out.println("Object Constructed with Default Constructor");
		//item = new FoodItem(); // HIGH COUPLING | This must not be done :(
		// FoodItem Object construction is dependent on Restaurant Object Construction
	}
	
	// Dependency is resolved with constructor
	public Restaurant(FoodItem item) {
		System.out.println("Object Constructed with Parameterized Constructor 1 - DI");
		this.item = item; // LOW COUPLING | This is OK
		// FoodItem Object construction is independent of Restaurant Object Construction
	}
	
	public Restaurant(List<String> departments) {
		System.out.println("Object Constructed with Parameterized Constructor List - DI");
		this.departments = departments; // LOW COUPLING | This is OK
	}

	public Restaurant(String name, String phone, String address, FoodItem item) {
		System.out.println("Object Constructed with Parameterized Constructor 2");
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.item = item;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public FoodItem getItem() {
		return item;
	}

	// setter function: with which we can link FoodItem object with Restaurant object
	public void setItem(FoodItem item) { // LOW COUPLING | This is OK
		System.out.println("Setter Method [FoodItem] - DI");
		this.item = item;
	}

	public List<String> getDepartments() {
		return departments;
	}

	public void setDepartments(List<String> departments) {
		System.out.println("Setter Method [departments] - DI");
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", address=" + address + ", item=" + item + "]";
	}

}
