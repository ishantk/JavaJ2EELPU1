package com.auribises.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// MODEL or BEAN or POJO (Plain Old Java Object)
@Entity
@Table(name = "MY_RESTAURANTS")
public class Restaurant {
	
	// Attributes
	@Id
	@GeneratedValue
	@Column(name = "RID")
	public Integer rid;

	@Column(name = "NAME")
	public String name;
	
	@Column(name = "PHONE")
	public String phone;
	
	@Column(name = "ADDRESS")
	public String address;
	
	@Column(name = "TYPE")
	public String type;
	
	@Column(name = "RATINGS")
	public Double ratings;
	
	@Column(name = "HOURS")
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

	public void showRestaurant() {
		System.out.println("------------["+rid+"]-------------");
		System.out.println(name+" | "+phone);
		System.out.println(type+" | "+ratings);
		System.out.println(operatingHours);
		System.out.println(address);
		System.out.println("----------------------------------");
	}
	
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", name=" + name + ", phone=" + phone + ", address=" + address + ", type="
				+ type + ", ratings=" + ratings + ", operatingHours=" + operatingHours + "]";
	}
	
}
