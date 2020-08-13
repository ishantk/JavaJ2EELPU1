import java.util.Scanner;

/*
 	OOPS:
 	Use Case : Make My Trip
 	
 	
 	Object Oriented Programming Structure
 	> Object
 	> Class
 	
 	Object is a Multi Value Container. It is meant to hold data :)
 		Data may be homo or hetro
 		Object will store the data as key/value pair -> attribute/data :)
 	
 	Class is a textual representation how our object will look like in memory
 	i.e. we code the object as class :)
 	
 	Principle of OOPS
 	~~~~~~~~~~~~~~~~~
 	1. Think about Object
 		anything in our problem statement which may have lot of data associated to it
 		Write data associated with it which we call as attributes
 	2. Create the Class for that Object
 	3. From the class create a Real Object in Memory :)		
 
 	Problem Statement: Client needs a travel web app from us as developers
 	 				   we need to think of a solution:
 	 				   we got below options:
 	 				   Flight Booking, Train Booking, Cab Booking, Bus Booking.....
 	 				   
 	 				   FlightBooking -> is an Object
 	 				    Attributes:
 	 				   	from, to, departureDate, travelers, travelClass
 	 				   	// Here we need to think as much as we can to gather data for FlightBooking
 	 		 
 	 		
 
 */

// 1. Think about Object
// OneWayFlightBooking [from, to, departureDate, travelers, travelClass] 

// 2. Create the Class for that Object
// This is definition of object in memory :)
class OneWayFlightBooking{ // whatever is Object -> becomes class name :)
	
	// Attributes: we are writing them in class, but they belong to object
	String from;
	String to;
	String departureDate;
	int travelers;
	int travelClass; // 1 -> economy, 2 business, 3 premium economy
	
	/*
	OneWayFlightBooking(){	// Default Constructor | Same name as taht of class name and if we do not create it, compiler creates it with default data
		from = null;
		to = null;
		departureDate = null;
		travelers = 0;
		travelClass = 0;
	}*/
	
	// Default Constructor  -> Sets the default data in Object
	OneWayFlightBooking(){	
		System.out.println("OneWayFlightBooking Constructed wiht Default Constructor: "+this); // hashCode of the object constructed will be printed
		from = "Delhi";
		to = "Banaglaore";
		departureDate = "14th Aug, 2020";
		travelers = 1;
		travelClass = 1;
	}
	
	// Parameterized Constructor -> Take input and than set the data
	OneWayFlightBooking(String from, String to, String departureDate, int travelers, int travelClass){
		System.out.println("OneWayFlightBooking Constructed wiht Parameterized Constructor: "+this); // hashCode of the object constructed will be printed
		// this is a reference variable which holds the hashcode of object
		// LHS this.from means attribute of object
		// RHS from means input of constructor
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	// METHOD -> Property of Object
	void showFlightBookingDetails() {
		System.out.println("Flight Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate);
		System.out.println("Travelers: "+travelers+" Class: "+travelClass);
		System.out.println();
	}
	
	void setOneWayFlightBookingDetails(String from, String to, String departureDate, int travelers, int travelClass){
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	void setOneWayFlightBookingDetails() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter From Location: ");
		from = scanner.nextLine();
		
		System.out.println("Enter To Location: ");
		to = scanner.nextLine();
		
		System.out.println("Enter Departure Date: ");
		departureDate = scanner.nextLine();
		
		System.out.println("Enter Travellers: ");
		travelers = scanner.nextInt();
		
		System.out.println("Enter Travell Class (1. Economy, 2. Business, 3. Premium Economy): ");
		travelClass = scanner.nextInt();
		
		scanner.close();
	}
	
}


// Class is For execution of our Program
public class OOPS {

	public static void main(String[] args) {
		
		// 3. From the class create a Real Object in Memory
		OneWayFlightBooking fRef1 = new OneWayFlightBooking();	// Object Construction
		OneWayFlightBooking fRef2 = new OneWayFlightBooking();  // Object Construction
		OneWayFlightBooking fRef3 = fRef1;						// Reference Copy
		
		OneWayFlightBooking fRef4 = new OneWayFlightBooking("Delhi", "Goa", "20th Aug, 2020", 6, 2);
		
		// new is operator which creates the object dynamically i.e. at run time in the Heap
		// executes Constructor when object is constructed as 1st function call to initialize attributes with some default data
		// fRef1, fRef2, Fref3 are reference variables which holds hashcode of objects and new returns the hashcode after creating the object
		
		System.out.println("fRef1 is: "+fRef1);
		System.out.println("fRef2 is: "+fRef2);
		System.out.println("fRef3 is: "+fRef3);
		System.out.println("fRef4 is: "+fRef4);
		
		fRef1.departureDate = "1st Sep, 2020";
		
		//fRef2.setOneWayFlightBookingDetails("Delhi", "Hyderabad", "2nd October, 2020", 4, 3);
		fRef2.setOneWayFlightBookingDetails();
		
		// Operations on Object
		// 1. Read Operation i.e. read data from object
		// We will use ref var with . operator to access the attribute of an object :)
//		System.out.println(fRef1.from+" "+fRef1.to+" "+fRef1.departureDate+" "+fRef1.travelers+" "+fRef1.travelClass);
//		System.out.println(fRef2.from+" "+fRef2.to+" "+fRef2.departureDate+" "+fRef2.travelers+" "+fRef2.travelClass);
//		System.out.println(fRef3.from+" "+fRef3.to+" "+fRef3.departureDate+" "+fRef3.travelers+" "+fRef3.travelClass);
//		System.out.println(fRef4.from+" "+fRef4.to+" "+fRef4.departureDate+" "+fRef4.travelers+" "+fRef4.travelClass);
		
		fRef1.showFlightBookingDetails();
		fRef2.showFlightBookingDetails();
		fRef3.showFlightBookingDetails();
		fRef4.showFlightBookingDetails();
		
		// Remember, Objects are deleted from the memory automatically
		// Garbage Collector will execute in some interval of time and pick up the unused objects are remove them with mark and sweep algo
		
		// Here we request GC to run immediately on our request to clean the memory for unused objects :)
		System.gc();
		
	}

}
