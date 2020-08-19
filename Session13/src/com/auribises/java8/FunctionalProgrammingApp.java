package com.auribises.java8;

@FunctionalInterface
interface AmazonPay{
	void onResult(String message); // -> public abstract void onResult(String message);
	//void onSuccess();
	//void onFailure();
	
	default void showAppTitle() {
		System.out.println("~~~~~~~~~~");
		System.out.println("AmazonPay");
		System.out.println("~~~~~~~~~~");
	}
	
	static void showRechargeOperators() {
		System.out.println("~~~~~~~~~~~~");
		System.out.println("Reliance | Airtel | Vodafone | Orange");
		System.out.println("~~~~~~~~~~~~");
	}
}
// FunctionalInterfaces are also known as Single Abstract Method (SAM) Interfaces 

// Interface can extend a Functional Interface and hence, the rule available in AmazonPay has to be implemented for any class implementing Inf
interface Inf extends AmazonPay{
	void hello();
	void bye();
}

class Payments implements Inf{
	@Override
	public void onResult(String message) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void bye() {
		// TODO Auto-generated method stub
		
	}
}

@FunctionalInterface
interface GooglePay{ 
	void onResult(String message);
	//void hello(); // error
	
	// In Functional Interface we can declare the methods of the Object class to be defined by children
	int hashCode();			// allowed
	String toString();		// allowed
}

class ZomatoPayments implements AmazonPay{
	@Override
	public void onResult(String message) {
		System.out.println("Message is: "+message);
		if(message.contains("SUCCESS")) {
			System.out.println("Payment Procesing Done");
		}else {
			System.out.println("Something Went Wrong");
		}
	}
}

public class FunctionalProgrammingApp {

	public static void main(String[] args) {
		
		AmazonPay aPay = new ZomatoPayments();
		aPay.onResult("SUCCESS for Payment of Rs 20000");

	}

}
