package com.auribises.java8;

import java.util.ArrayList;
import java.util.List;

class Customer{
	
	String name;
	String phone;
	int age;
	
	boolean isPrime;
	
	Customer(){
		
	}
	
	Customer(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		isPrime = false;
	}

	String getCustomerDetails() {
		if(isPrime) {
			return "[PRIME CUSTOMER]: "+name+" | "+phone+" | "+age;
		}else {
			return "[REGULAR CUSTOMER]: "+name+" | "+phone+" | "+age;
		}
	}
	
}

@FunctionalInterface
interface PrimeCustomer{
	String upgradeCustomerToPrimeMember(Customer customer);
}

public class LambdExpressionOOPS {

	public static void main(String[] args) {
		
		PrimeCustomer primeCustomer = (customer) -> {
			customer.isPrime = true;
			String message = "Thank You "+customer.name+" for becoming a Prime Customer With Us";
			return message;
		};
		
		Customer cRef = new Customer("John", "+91 98765 12345", 24);
		System.out.println(cRef.getCustomerDetails());
		
		System.out.println();
		
		String message = primeCustomer.upgradeCustomerToPrimeMember(cRef);
		System.out.println(message);
		System.out.println(cRef.getCustomerDetails());

		System.out.println();
		
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Jennie");
		names.add("Jim");
		names.add("Jack");
		names.add("Joe");
		
		/*for(String name : names) {
			System.out.println(name);
		}*/
		
		// for each lambda expression a built in one can be used with Collections
		names.forEach((name)->System.out.println(name));
		
		
		// Assignment:
		// Explore forEach Lambda Expression with Set, Tree, Map :)
	}

}
