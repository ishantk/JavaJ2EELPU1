package com.auribises.beans;

// bean :)
public class Manager {
	
	String name;
	String phone;
	Integer salary;
	
	public Manager() {
		
	}
	
	public Manager(String name, String phone, Integer salary) {
		this.name = name;
		this.phone = phone;
		this.salary = salary;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", phone=" + phone + ", salary=" + salary + "]";
	}

}
