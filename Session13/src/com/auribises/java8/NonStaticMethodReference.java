package com.auribises.java8;

@FunctionalInterface
interface OrderState{
	String getState(int state);
}

class CustomerOrder{
	
	String getOrderState(int state) {
		if(state ==1)	return "ORDER PLACED";
		else			return "ORDER DELIVERED";
	}
	
}

public class NonStaticMethodReference {

	public static void main(String[] args) {
		
		CustomerOrder order = new CustomerOrder();
		//System.out.println(order.getOrderState(2));
		
		OrderState oState = order::getOrderState; // here we are using Object's Reference Variable to Pass the Reference
		System.out.println(oState.getState(1));
		
	}

}
