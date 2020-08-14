package com.auribises.one;	// Below classes in this file, will be created in the package com.auribises.one

// public class
public class One {
	
	public One() {
		System.out.println("One Object Constructed");
	}

	// within the class we can make attributes or methods any one out of 4 
	
	private void pvtShow() {
		System.out.println("This is private show of One");
	}
	
	void defShow() {
		//pvtShow(); // OK But cannot access it outside the class
		System.out.println("This is default show of One");
	}
	
	protected void protShow() {
		System.out.println("This is protected show of One");
	}
	
	public void pubShow() {
		System.out.println("This is public show of One");
	}
	
}

// default class
class Two{
	
	private void pvtShow() {
		System.out.println("This is private show of Two");
	}
	
	void defShow() {
		System.out.println("This is default show of Two");
	}
	
	protected void protShow() {
		System.out.println("This is protected show of Two");
	}
	
	public void pubShow() {
		System.out.println("This is public show of Two");
	}
	
}

/*
private class Three{ // error
	
}

protected class Four{ // error
	
}
*/

// In 1 source file we can have only 1 public class
// Because, java says, if a class is public, name of the source file should be same name as that of public class
/*public class Five{ // error
	
}*/

// But, we can have n-number of default classes in the same source file
/*class Six{ // OK
	
}*/

// In Java we cannot create private or protected class in .java file :)
// PS: We can either create a public class or default class


/*
 	private: accessible only within the class and not outside
 			 limited only to the class 
 			 
 	default: accessible only within the package and not outside
 			 limited only to the package
 			 
 	protected: accessible only within the package and not outside
 			   limited only to the package
 			   
 	public: accessible everywhere
 			   no limits	 		   		 
*/