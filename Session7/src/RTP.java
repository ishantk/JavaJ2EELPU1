import java.util.Scanner;

class Cab{
	
	// Attributes
	int baseFare;
	int pricePerKm;
	
	Cab(){
		baseFare = 100;
		pricePerKm = 10;
		System.out.println("Cab Object Constructed");
	}
	
	void bookCab(String fromLocation, String toLocation) {
		System.out.println("CAB Booked from "+fromLocation+" to "+toLocation);
		System.out.println("Please Pay: \u20b9"+baseFare);
	}
	
	static void showAppName() {
		System.out.println("OLA");
	}
	
}

class OlaMini extends Cab{
	
	String wifiUserName;
	String password;
	
	OlaMini(){
		wifiUserName = "auribises";
		password = "pass@123";
		baseFare += 50;
		System.out.println("Ola Mini Object Constructed");
	}
	
	void bookCab(String fromLocation, String toLocation) { // Overriding
		System.out.println("OLA MINI Booked");
		super.bookCab(fromLocation, toLocation);
		System.out.println("Wifi Details: Username:"+wifiUserName+" Password: "+password);
	}
	
	static void showAppName() { // Hiding
		System.out.println("OLA - book mini cab");
	}
	
}

class OlaBike extends Cab{
	
	boolean isHelmetAvailable;
	
	OlaBike(){
		isHelmetAvailable = true;
		baseFare -= 50;
		System.out.println("Ola Bike Object Constructed");
	}
	
	void bookCab(String fromLocation, String toLocation) {
		System.out.println("OLA BIKE Booked");
		super.bookCab(fromLocation, toLocation);
		System.out.println("Will Helmet be Available: "+isHelmetAvailable);
	}
	
	static void showAppName() { // Hiding -> we will hide the method of the Parent in Child
		System.out.println("OLA - book bike");
	}
	
	void hello() {
		
	}
}


public class RTP {

	public static void main(String[] args) {
	
		/*
		Cab cRef;
		cRef = new Cab();
		
		cRef.bookCab("Work", "Home");*/
		
		/*
		OlaMini omRef;
		omRef = new OlaMini();
		
		omRef.bookCab("Work", "Home");
		
		System.out.println();
		
		OlaBike obRef;
		obRef = new OlaBike();
		
		obRef.bookCab("Work", "Home");
		*/
		
		// Why Overriding -> So as we can show some customized details :)
		//					 OR, we can perform any customized logical operations as per child
		
		// Polymorphic Statement:
		// Parent's Ref Variable can point to the Object of Child
		// Vice Versa isn't possible
		
		/*
		Cab cRef;
		
		cRef = new OlaMini();
		cRef.bookCab("Work", "Home");	// This will override the Parent function, and child version will be executed
		
		System.out.println();
		
		cRef = new OlaBike();
		cRef.bookCab("Work", "Home");	
		
		// Parent's ref var can point to any of its child object :)
		// Same var can refer to different objects -> More than 1 form or Polymorphism

		*/
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. For Ola Mini");
		System.out.println("2. For Ola Bike");
		
		int choice = scanner.nextInt();
		scanner.close();
		
		Cab cRef = null; // Reference Variable of Parent
		
		if(choice == 1) {
			cRef = new OlaMini();
		}else if(choice == 2) {
			cRef = new OlaBike();
		}else {
			System.out.println("Please Select the Valid Cab");
		}
		
		if(cRef !=null) {
			cRef.showAppName(); // let the execution of Child class method | static methods, in polymorphic structure it will be Parent's Function
			cRef.bookCab("Work", "Home");
			//cRef.hello(); // error: can access the functions which will be over-rided by children
		}
	}

}
