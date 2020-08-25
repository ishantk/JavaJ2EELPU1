package com.auribises.beans;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{

	// PS: before shall be executed before the business method
	
	// method -> reference to the method executed in the bean
	// inputs -> inputs to the method of the bean
	// reference -> reference pointing to the bean object
	@Override
	public void before(Method method, Object[] inputs, Object reference) throws Throwable {
		System.out.println("==before executed==");
		
		// 1. Check for Stock
		//    may be a query on the database for evaluating that product can be purchased or not
		//    in case we have the stock, active attribute remains true else we make it false :)
		// Pre-Processing
		System.out.println("[PRE-PROCESSING] - Validating Order Stock");
		System.out.println();
		
		// before method must do pre-processing for purchaseProduct business method
		if(method.getName().equals("purchaseProduct")) {
			Product product = (Product)reference;
			
			if(product.stock == 0) {
				product.active = false; // make product in-active
			}
		}
		
		System.out.println("==before finsihed==");
		System.out.println();
	}

}
