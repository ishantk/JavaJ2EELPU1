package com.auribises.model;

/*
 
 	
Persistence
	1. Files
		Challenge: Unstructured Storage
				   Hence, write operations for update and delete some information in file becomes challenging
				   Security is a big concern
	2. DataBases:
				   Which stores the data permanently
				   DB is structured i.e. we have a way to store and manage data
				   Secure as we need to access DB with username and password

				   1. MySQL 	-> Oracle
				   2. MongoDB

	Install MySQL on your system -> local database storage
	MongoDB in the cloud

	-------------------------------
	ORM : Object Relational Mapping
	-------------------------------
	// Java
	class Customer{
		// Attributes
		public String name;
		public String phone;
		public String email;
		public double temperature;
		public String entryDateTime;
		public String exitDateTime;
	}
	
	// SQL
	create table Customer(
		id int primary key auto_increment,
		name varchar(256),
		phone varchar(256),
		email varchar(256) unique key,
		temperature float,
		entryDateTime varchar(256),
		exitDateTime varchar(256)
	)
	
	CRUD Operations | Create, Retrieve, Update and Delete
	
	// Java
	Customer cRef = new Customer("John", "+91 99999 11111", "john@example.com", 98.9, "18-08-2020 17:20:00", "NA");
	
	// SQL
	insert into Customer values(null, 'John', '+91 99999 11111', 'john@example.com', 98.9, '18-08-2020 17:20:00', 'NA')
	
	// Java
 	cRef.updateCustomerDetails("John Watson", "+91 99999 11111", "john.watson@example.com", 98.4, "18-08-2020 17:20:00", "18-08-2020 17:30:00");
 	
 	// SQL
 	update Customer set name = 'John Watson', email = 'john.watson@example.com', temperature=98.4, exitDateTime = '18-08-2020 17:30:00' where email = 'john@example.com'
 	
 	// Java
 	Deletion happens automatically as data is already temporary
 	
 	// SQL
 	Here in Tables, data is saved permanently
 	delete from Customer where email = 'john.watson@example.com'
 	
 	// Java
 	ArrayList to hold all the Objects 
 	
 	// SQL
 	select * from Customer -> all the customers as ResultSet
 	select * from Customer where temperature > 99.0
 	select name, phone from Customer where temperature > 99.0
 	select name, phone from Customer where email = 'john.watson@example.com'
 	
 	// Steps:
 	1. Install MySQL DataBase on Your Computer
 	   1.1 Either Install MySQL Setup for which you need to access database on command prompt
 	   -> https://dev.mysql.com/downloads/installer/
 	   1.2 OR you can install XAMPP or WAMPP Servers on your computer to get a UI for DB Access
 	   -> https://www.apachefriends.org/download.html
 	   
 	   PS: remember the user name and password if you are providing during installation
 	   in case you dont put any username or password -> root is username and password is "" (blank)
 	   
 	2. Create the DataBase
 	3. Create the Table 
 	
 	--------------
 	JDBC PROCEDURE 
 	--------------
 	1. Load the Driver
 	   1.1 Download Library for MySQL from vendor Website
 	   1.2 Link the jar file with your project
 	   1.3 Use API Class.forname and load the Driver from jar file
 	   // Ref Link -> https://dev.mysql.com/downloads/connector/j/
 	   
 	2. Create the Connection with DatBase
 	   2.1 Connection URL String
 	   2.2 User Name and Password
 	   2.3 Use Connection API and Connect to the DataBase
 	   
 	3. Write SQL Statement and execute it
 	   3.1 Write Java String which shall represent SQL Query
 	   3.2 Use API Statement or PreparedStatement to perform SQL Query Operation
 	  
 	4. Close the Connection with DataBase  
 */

public class Customer{
	
	// Attributes
	public int id;
	public String name;
	public String phone;
	public String email;
	public double temperature;
	public String entryDateTime;
	public String exitDateTime;
	
	public Customer(){
		
	}
	
	public Customer(String name, String phone, String email, double temperature, String entryDateTime, String exitDateTime) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.temperature = temperature;
		this.entryDateTime = entryDateTime;
		this.exitDateTime = exitDateTime;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", temperature="
				+ temperature + ", entryDateTime=" + entryDateTime + ", exitDateTime=" + exitDateTime + "]";
	}
	
}