package com.auribises.bean;

/*
 
 create table Employee(
	 eid int primary key auto_increment,
	 name varchar(256),   
	 phone varchar(256),
	 department varchar(256),    
	 designation varchar(256),        
	 salary int
)  
 
 */

public class Employee {
	
	public Integer eid;
	public String name;
	public String phone;
	public String department;
	public String designation;
	public Integer salary;
	
	public Employee() {
		
	}
	
	public Employee(Integer eid, String name, String phone, String department, String designation, Integer salary) {
		this.eid = eid;
		this.name = name;
		this.phone = phone;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", phone=" + phone + ", department=" + department
				+ ", designation=" + designation + ", salary=" + salary + "]";
	}

}
