// 1. Single Level Inheritance -> 1 Parent and 1 Child
class CA{
	
	
}

class CB extends CA{	
	
	
}

// 2. Multi Level Inheritance -> Parent to Child and Child to GrandChild
class CC extends CB{
	
}

// 3. Hierarchy -> Same Parent Multiple Children
class CD extends CA{
	
}

class CE{
	
}

// 4. Multiple -> More than 1 Parent
/*class CF extends CA, CE{ // ERROR : Multiple Inheritance Not Supported in Java
	
}*/
// Diamond Problem like in C++ cannot be resolved here in Java as we have no concept of virtual keyword and pointers in java

public class InheritanceTypes {

	public static void main(String[] args) {
		

	}

}
