package com.auribises.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurant {

	String name;
	String phone;
	String address;
	double ratings;
	String operatingHours;
	
	// Dependency
	Manager manager; // Has-A Relationship | 1 to 1

	public Restaurant() {
		// HIGH COUPLING -> Creating Object of Manager is within the constructor of Restaurant which means till Restaurant Object is not created, Manager object will not be created
		//manager = new Manager(); // we should not write the object directly here !!
	}
	
	// Restaurant Constructor -> with its help we link the manager with the Restaurant Object :)
	// LOW COUPLING
	// @Autowired is annotation which tells IOC Container to link the dependency with constructor here
	// Auto-Wiring will find the Object with id as Manager and link it with restaurant object :)
	@Autowired
	public Restaurant(Manager manager) {
		System.out.println("[CONSTRUCTOR INJECTION] Restaurant Object Constructed with Manager as Input");
		this.manager = manager;
	}


	public Restaurant(String name, String phone, String address, double ratings, String operatingHours,
			Manager manager) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ratings = ratings;
		this.operatingHours = operatingHours;
		this.manager = manager;
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

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public Manager getManager() {
		return manager;
	}

	// setter function -> with its help we link the manager with the Restaurant Object :)
	// LOW COUPLING
	// @Autowired can be used with Constructor OR Setter :)
	@Autowired
	public void setManager(Manager manager) {
		System.out.println("[SETTER INJECTION] Restaurant Object Constructed with Manager as Input");
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", address=" + address + ", ratings=" + ratings
				+ ", operatingHours=" + operatingHours + ", manager=" + manager + "]";
	}
	
}
