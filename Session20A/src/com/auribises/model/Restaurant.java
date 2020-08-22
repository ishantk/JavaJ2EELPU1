package com.auribises.model;

public class Restaurant {

	Integer rid;
	String name;
	String phone;
	String address;
	Double ratings;
	
	Manager manager; // HAS-A Relationship :) | 1 to 1

	public Restaurant() {
	
	}
	
	public Restaurant(Integer rid, String name, String phone, String address, Double ratings, Manager manager) {
		this.rid = rid;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ratings = ratings;
		this.manager = manager;
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

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", name=" + name + ", phone=" + phone + ", address=" + address + ", ratings="
				+ ratings + ", manager=" + manager + "]";
	}
	
}
