package com.auribises.main;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auribises.beans.Product;

/*
 
 Spring AOP
	Creating Advices (Methods which executes before or after the method)	

	Aspect Oriented Programming :)
		Here, we divide the logic into multiple parts
		we manage pre-processing or post-processing

		APIs
			MethodBeforeAdvice
			AfterReturningAdvice


	Use Case
	>> PlaceOrder on eCom Platform
		buy an iPhone 

	BusinessLogic
		1. Check the Stock						- PreProcessing
		2. Make the payments and do the transaction -| Core Logic
		3. Generate Order Object with some data 	-| Core Logic
		4. Notify User and Shipment Department  - PostProcessing


	Splitting the Business Logic and Executing the Same with Spring
	We need to use Spring AOP
 
 */


// Spring AOP Procedure:
/*
 	
 	Steps
 		1. Configure Project for Spring Core and Spring AOP Jar Files
 		2. Write Bean with Business Logic
 		3. Write BeforeAdvice or AfterReturingAdvice or Both as per requirement
 		4. Configure Advice in Spring xml configuration file with ProxyFactoryBean API 
 		5. In the main class use IOC Container to get bean's reference and execute the business logic
 	
 
*/

public class SpringAOP {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		//Product product = context.getBean("product", Product.class);
		Product product = context.getBean("proxyBean", Product.class);
		//System.out.println(product);
		
		// Execute the business logic
		product.purchaseProduct("Office", "Evening");
		
		//ProxyFactoryBean API to be configured in xml file :)

	}

}
