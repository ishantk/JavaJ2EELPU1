interface Inf1{
	void show();
}

interface Inf2{
	void hello();
	void show();
}

// Interfaces can inherit and can inherit in multiple fashion also
interface Inf3 extends Inf1, Inf2{
	
}

// A class can implement multiple interfaces, but this is not multiple inheritance
class CP implements Inf3{ //Inf1, Inf2{
	
	public void show() {
		System.out.println("This is show from Inf1");
	}
	
	public void hello() {
		System.out.println("This is hello from Inf2");
	}
	
	void bye() {
		System.out.println("This is bye from CP");
	}
}

public class Interfaces {

	public static void main(String[] args) {
		/*
		CP cRef = new CP();
		cRef.show();
		cRef.hello();
		cRef.bye();
		*/
		
		// In a Polymorphic Statement, with Parent's Ref we can access only those methods which are re-defined in the Child
		// In a Polymorphic Statement, with Interface Ref we can access only those methods which are defined in the class which implements it
		Inf1 iRef1 = new CP();
		iRef1.show();
		//iRef1.hello();  // error
		//iRef1.bye(); 	// error
		
		Inf3 iRef3 = new CP();
		iRef3.show();
		iRef3.hello();

	}

}
