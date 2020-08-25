package com.auribises.dp;

import java.util.ArrayList;

interface State{
	String getState();
}

class Offline implements State{
	
	public String getState() {
		return "OFFLINE";
	}
}

class Online implements State{
	
	public String getState() {
		return "ONLINE";
	}
}

class Available implements State{
	
	public String getState() {
		return "AVAILABLE";
	}
}

class OnRide implements State{
	
	public String getState() {
		return "ONRIDE";
	}
}

class Customer{
	
	Ride ride;
	
	void bookRide(String source, String destination) {
		ride = new Ride();
		ride.findAvailableDriver();
	}
	
}

class Driver{
	
	State state; // Has-A Relationship
	Ride ride;
	
	void changeState(State state) {
		this.state = state;
	}
	
	void allocateRideToDriver(Ride ride) {
		this.ride = ride;
	}
}

class Ride{
	
	void findAvailableDriver() {
		
		boolean flag = false;
		
		for(Driver driver : UberStateApp.drivers) {
			if(driver.state.getState().equals("ONLINE")) {
				driver.changeState(new OnRide());
				System.out.println("Driver Booked :)");
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("Sorry !! No Drivers Avaiable Currently :( ");
		}
	}
}


public class UberStateApp {
	
	static ArrayList<Driver> drivers = new ArrayList<Driver>();

	public static void main(String[] args) {
		
		Driver driver1 = new Driver();
		Driver driver2 = new Driver();
		Driver driver3 = new Driver();
		
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		
		driver1.changeState(new OnRide());
		driver2.changeState(new OnRide());
		driver3.changeState(new Online());
		
		System.out.println("INITIAL STATES:");
		drivers.forEach((driver)->System.out.println(driver.state.getState()));
		
		Customer customer = new Customer();
		customer.bookRide("Office", "Home");
		
		System.out.println("FINAL STATES:");
		drivers.forEach((driver)->System.out.println(driver.state.getState()));
		
		customer.bookRide("Home", "Mall");

	}

}
