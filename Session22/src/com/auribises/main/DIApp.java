package com.auribises.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auribises.beans.Restaurant;

public class DIApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
		Restaurant ref = context.getBean("rest1", Restaurant.class);
		System.out.println(ref);
		System.out.println("Departments: ");
		System.out.println(ref.getDepartments());

	}

}

// Assignment: Link List of FoodItems with Restaurant in 1 to many relationship
// 			   Explore map and set tags in DI within xml file for HAS-A Relationship