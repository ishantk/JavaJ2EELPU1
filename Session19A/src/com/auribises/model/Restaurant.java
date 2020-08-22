package com.auribises.model;

// MODEL or BEAN or POJO (Plain Old Java Object)
public class Restaurant {
	
	// Attributes
	public Integer rid;
	public String name;
	public String phone;
	public String address;
	public String type;
	public Double ratings;
	public String operatingHours;
	
	public Restaurant() {
		
	}
	
	public Restaurant(Integer rid, String name, String phone, String address, String type, Double ratings,
			String operatingHours) {
		this.rid = rid;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.type = type;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", name=" + name + ", phone=" + phone + ", address=" + address + ", type="
				+ type + ", ratings=" + ratings + ", operatingHours=" + operatingHours + "]";
	}
	
}
