package com.auribises.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auribises.beans.Restaurant;

public class App {

	public static void main(String[] args) {
		
		// IOC Container
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// Requesting IOC Container to get the Object's Reference
		Restaurant rRef = context.getBean("restaurant", Restaurant.class);
		System.out.println(rRef);

	}

}

/*
 	
 	Spring Core
 		1. Bean (Java Object)
 		2. IOC  (Inversion of Control)
 		3. IOC Container (which manages object and its life cycle)
 			3.1. BeanFactory
 			3.2. ApplicationContext
 		4. DI (Dependency Injection)	
 		    4.1 Constructor Injection
 		    4.2 Setter Injection 
 		    can be managed through XML configuration or Annotations
 	
 */
