package com.auribises.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auribises.bean.Employee;
import com.auribises.dao.DB;

// Configure DriverManagerDataSource API as DataSource for Setter Injection
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
 	
 	Spring DataBase Integration
 	JDBC + MySQL
 	
 	Procedure
 	1. Link Spring Core Jar Files [IOC and DI]
 	2. Link Spring Persist Core Jar Files [JDBC or Hibernate] + MySQL or Any Relational DB Jar
 	3. Write the Model i.e. Bean or Object which we wish to work on w.r.t. DB
 	4. Create DAO Design Pattern
 		4.1 Write an Interface for What functions DAO pattern should have (eg: CRUD Functions)
 		4.2 Write an Implementation of interface
 		    Spring JDBC APIs to perform DB Operations
 	5. Write a Mapper which maps DB rows as Objects :)	
 	6. Configure beans.xml (i.e. Spring Configuration File) for Spring IOC Principle
 	7. In the Main Class, use IOC Container and execute the codes
 */

public class App {

	public static void main(String[] args) {
				
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// We will be requesting for the Object of DB 
		DB db = context.getBean("db", DB.class);
		System.out.println("DB Object Reference Obtained: "+db);
		
		// Perform CRUD Operations with DAO DB Object :)
		Employee eRef1 = new Employee(null, "John Watson", "+91 89898 89112", "R&D", "Project Manager", 90000);
		Employee eRef2 = new Employee(null, "Fionna", "+91 87654 11111", "R&D", "Manager", 80000);
		Employee eRef3 = new Employee(null, "Harry", "+91 99999 12345", "Accounts", "Accountant", 20000);
		Employee eRef4 = new Employee(null, "George", "+91 87655 12345", "Admin", "GM", 60000);
		Employee eRef5 = new Employee(null, "Mark", "+91 76541 12345", "Admin", "Executive", 30000);
		
		//db.saveEmployee(eRef1);
		//db.saveEmployee(eRef2);
		//db.saveEmployee(eRef3);
		//db.saveEmployee(eRef4);
		//db.saveEmployee(eRef5);
		
		//Employee emp = db.getEmployee(3);
		//System.out.println(emp);
		
		//db.deleteEmployee(3);
		
		//eRef1.setEid(1);
		//db.updateEmployee(eRef1);
		
		db.listEmployees().forEach((employee) -> System.out.println(employee));
		
	}

}

// Assignment #1:
// Implement Spring JDBC in Web App where We were Managing Restaurants :)

// Assignment #2:
// Implement Spring Hibernate i.e. ORM Module
// Configure XML File for HibernateTemplate to Work :)
// PS: you also need to configure hbm mapping file :)