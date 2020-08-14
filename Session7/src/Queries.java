class Parent{
	
	void purchaseBike() {
		System.out.println("Lets Purchase Bajaj Pulsar");
	}
	
	static void purchaseCar() {
		System.out.println("Lets Purchase Maruti Swift");
	}
}


class Child extends Parent{
	// super keyword is accessible only in Child class
	
	void purchaseBike() {
		//super.purchaseBike();
		System.out.println("Lets Purchase Royal Enfield");
	}
	
	static void purchaseCar() {
		// super.purchaseCar(); super keyword is to access object data | error
		// Rule: from static, we cannot access non static 
		//Parent.purchaseCar();
		System.out.println("Lets Purchase Honda City");
	}
}


public class Queries {

	public static void main(String[] args) {
		
		Child cRef = new Child();
		//cRef.super.purchaseBike(); super keyword is kind of protected -> we can access it only in Child class definition
		cRef.purchaseBike(); // Overriding :)

		System.out.println();
		
		Child.purchaseCar(); // it executes the definition in the Child
		
		//Parent oRef = new Child(); // Polymorphic Statement -> RTP Module :)
	}

}
