package com.auribises.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice{

	// PS: afterReturing shall be executed after the business method
	
	// method -> reference to the method executed in the bean
	// inputs -> inputs to the method of the bean
	// reference -> reference pointing to the bean object
	@Override
	public void afterReturning(Object arg0, Method method, Object[] inputs, Object reference) throws Throwable {
		
		System.out.println("==after executed==");
		
		if(method.getName().equals("purchaseProduct")) {
			
			Product product = (Product)reference;
			
			if(product.transaction) {
				System.out.println("[POST-PROCESSING] - NOTIFICATIONS");
				// 3. Notify Shipment department and Send Email and SMS to both Client and Shipment Department :)
				System.out.println("Shipment Department Notified Via - Email and SMS");
				System.out.println("Customer Notified Via - Email and SMS");
				
				
				System.out.println(product.name+" shall be delivered at "+inputs[0]+" by "+inputs[1]);
			}
		}
		
		System.out.println("==after finished==");
		System.out.println();
	}

}
