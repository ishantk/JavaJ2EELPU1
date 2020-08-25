package com.auribises.model;

public class Restaurant {

	public Integer rid;
	public String name;
	public String phone;
	public String type;
	public String address;
	public double ratings;
	public String operatingHours;
	
	
	public Restaurant() {
		
	}
	
	public Restaurant(Integer rid, String name, String phone, String type, String address, double ratings,
			String operatingHours) {
		this.rid = rid;
		this.name = name;
		this.phone = phone;
		this.type = type;
		this.address = address;
		this.ratings = ratings;
		this.operatingHours = operatingHours;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", type=" + type + ", address="
				+ address + ", ratings=" + ratings + ", operatingHours=" + operatingHours + "]";
	}
	
	
	
}
