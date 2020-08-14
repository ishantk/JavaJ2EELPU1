package com.auribises.two;

import com.auribises.one.One;
//import com.auribises.one.Two;  // Error -> default is accessible only within the package


// Package Level Inheritance :)
class Child extends One{
	
	Child(){
		System.out.println("Child Object Constructed");
	}
	
	void accessParentsMethods() {
		//pvtShow();
		//defShow();
		protShow();	// is accessible 
		pubShow();  // is accessible
	}
}

public class App {

	public static void main(String[] args) {
		
		//One oRef = new One();
		//oRef.pvtShow();   // error
		//oRef.defShow();	// error
		//oRef.protShow();  // error
		//oRef.pubShow();   // OK

		Child cRef = new Child(); // in memory, object of Parent will be created before the object of child
		
		cRef.accessParentsMethods();
		cRef.pubShow();  // allowed  -> direct access
		//cRef.protShow(); // not allowed -> direct access | 
		// protected behaves as private outside the package after inheritance
	}

}
