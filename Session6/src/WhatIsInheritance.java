class Parent{
	
	// Attributes of Parent Object
	String fname;
	String lname;
	int wealth;
	
	// Constructor of Parent Object
	Parent(){
		fname = "John";
		lname = "Watson";
		wealth = 100000;
		System.out.println("Parent Object Constructed");
	}
	
	// Method of Parent Object
	void showDetails() {
		System.out.println("[P]: "+fname+" "+lname+" | "+wealth);
	}
}

// Inheritance Relationship in Java :)
// with extends we relate 2 classes as Parent and Child | LHS(child) extends RHS(parent)
class Child extends Parent{ 
	
	String fname;
	int wealth;
	
	Child(){
		fname = "Fionna";
		wealth = 57500;
		System.out.println("Child Object Constructed");
	}
	
	void showDetails() {
		super.showDetails(); // execute showDetails of Parent as well
		System.out.println("Parent fname is: "+super.fname);
		System.out.println("[C]: "+fname+" "+lname+" | "+wealth);
	}
	
}

// 1st Rule of Inheritance
// Before the Object of Child, JVM will create Object of Parent in the memory :)

// 2nd Rule of Inheritance
// Child can access everything in the Parent, if it wont have it within it :)
// * -> private is not accessible -> see in our next discussion

public class WhatIsInheritance {

	public static void main(String[] args) {
		
		/*Parent pRef = new Parent();
		pRef.showDetails();*/
		
		Child cRef = new Child();
		
		// if child has no wealth attribute within it, but parent has it, so child will access of its Parent's
		// if child has it, it will access its own
		cRef.wealth -= 10000; 
		
		// showDetails is not in the child, but available in the Parent and hence is accessible
		// if showDetails is in the Child, it will execute its method and not the Parent's
		cRef.showDetails(); 

	}

}
// Assignment: Explore Overriding in case of static methods !!
