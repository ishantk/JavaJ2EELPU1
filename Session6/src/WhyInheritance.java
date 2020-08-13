/*
class OneWayFlightBooking{ // whatever is Object -> becomes class name :)
	
	// Attributes: we are writing them in class, but they belong to object
	String from;
	String to;
	String departureDate;
	int travelers;
	int travelClass; // 1 -> economy, 2 business, 3 premium economy
	
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
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	void showFlightBookingDetails() {
		System.out.println("Flight Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate);
		System.out.println("Travelers: "+travelers+" Class: "+travelClass);
		System.out.println();
	}
	
}	

class RoundTripFlightBooking{ // whatever is Object -> becomes class name :)
	
	// Attributes: we are writing them in class, but they belong to object
	String from;
	String to;
	String departureDate;
	String returnDate;	// this is 1 additional attribute
	int travelers;
	int travelClass; // 1 -> economy, 2 business, 3 premium economy
	
	RoundTripFlightBooking(){	
		System.out.println("OneWayFlightBooking Constructed wiht Default Constructor: "+this); // hashCode of the object constructed will be printed
		from = "Delhi";
		to = "Banaglaore";
		departureDate = "14th Aug, 2020";
		travelers = 1;
		travelClass = 1;
	}
	
	// Parameterized Constructor -> Take input and than set the data
	RoundTripFlightBooking(String from, String to, String departureDate, String returnDate, int travelers, int travelClass){
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	void showFlightBookingDetails() {
		System.out.println("Flight Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate+" Return: "+returnDate);
		System.out.println("Travelers: "+travelers+" Class: "+travelClass);
		System.out.println();
	}
	
}

class OneWayCabBooking{ // whatever is Object -> becomes class name :)
	
	// Attributes: we are writing them in class, but they belong to object
	String from;
	String to;
	String departureDate;
	String pickUpTime;
	
	OneWayCabBooking(){	
		System.out.println("OneWayFlightBooking Constructed wiht Default Constructor: "+this); // hashCode of the object constructed will be printed
		from = "Delhi";
		to = "Banaglaore";
		departureDate = "14th Aug, 2020";
		pickUpTime = "10:00";
	}
	
	// Parameterized Constructor -> Take input and than set the data
	OneWayCabBooking(String from, String to, String departureDate, String pickUpTime){
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.pickUpTime = pickUpTime;
	}
	
	void showCabBookingDetails() {
		System.out.println("Cab Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate);
		System.out.println("PickUp: "+pickUpTime);
		System.out.println();
	}
	
}
*/
	
// Whenever we code, we will find snippets getting repeatedly used in different classes
// This is a case of generalization

// Common Code in above 3 classes is now generalized as a class Booking
class Booking{ 
	
	// Attributes: we are writing them in class, but they belong to object
	String from;
	String to;
	String departureDate;
	
	Booking(){	
		
	}
	
	// Parameterized Constructor -> Take input and than set the data
	Booking(String from, String to, String departureDate){
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
	}
	
	void showBookingDetails() {
		System.out.println("Booking Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate);
	}
	
}	

// 3rd Rule of Inheritance: we should create a child class so as to extend the general class 
// To save development Time
// Reuse Existing Code i.e. Existing class :)
class OneWayFlightBooking extends Booking{
	
	// in the Child, we must write additional attributes
	int travelers;
	int travelClass; // 1 -> economy, 2 business, 3 premium economy
	
	OneWayFlightBooking(){	
		
	}
	
	// Parameterized Constructor -> Take input and than set the data
	OneWayFlightBooking(String from, String to, String departureDate, int travelers, int travelClass){
		super(from, to, departureDate); // let us pass on this to the Parent Constructor and it will set up the data in Parent object
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	void showBookingDetails() {
		System.out.println("One Way Flight Details:");
		super.showBookingDetails(); // execute from Parent
		System.out.println("Travelers: "+travelers+" Class: "+travelClass);
		System.out.println();
	}
	
}

class OneWayCabBooking extends Booking{
	
	// in the Child, we must write additional attributes
	String pickupTime;
	
	OneWayCabBooking(){	
		
	}
	
	// Parameterized Constructor -> Take input and than set the data
	OneWayCabBooking(String from, String to, String departureDate, String pickupTime){
		super(from, to, departureDate); // let us pass on this to the Parent Constructor and it will set up the data in Parent object
		this.pickupTime = pickupTime;
	}
	
	void showBookingDetails() {
		System.out.println("One Way Cab Details:");
		super.showBookingDetails(); // execute from Parent
		System.out.println("Pickup Time "+pickupTime);
		System.out.println();
	}
	
}

public class WhyInheritance {

	public static void main(String[] args) {
		
		OneWayFlightBooking ofRef = new OneWayFlightBooking("Delhi", "Bangalore", "15th Aug, 2020", 2, 1);
		OneWayCabBooking ocRef = new OneWayCabBooking("Goa", "Mumabi", "20th Aug, 2020", "12:00");
		
		ofRef.showBookingDetails();
		ocRef.showBookingDetails();
		

	}

}
