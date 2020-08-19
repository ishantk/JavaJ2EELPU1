package com.auribises.java8;

@FunctionalInterface
interface LocationListener{
	void onLocationChanged(double latitude, double longitude);
}

// We need to write a class separately implementing interface
class LocationTrackerApp implements LocationListener{
	@Override
	public void onLocationChanged(double latitude, double longitude) {
		System.out.println("Location Changed to: "+latitude + " | "+longitude);
	}
}

@FunctionalInterface
interface Email{
	String sendEmail(String from, String to);
	//void hello();// for lambda expression we cannot have more than 1 method
	// Hence, we keep the annotation @@FunctionalInterface to satsfy condition for writing a lambda expression
}

class GPS{
	
	LocationListener listener;
	
	void registerForLocationUpdates(LocationListener listener) {
		this.listener = listener;
	}
	
	void updateLocation(double latitude, double longitude) {
		listener.onLocationChanged(latitude, longitude);
	}
	
}

public class LambdaExpressionApp {

	public static void main(String[] args) {
		
		/*
		LocationTrackerApp app = new LocationTrackerApp();
		
		GPS gps = new GPS();
		gps.registerForLocationUpdates(app);
		
		// GPS Module Notifies the LocationTrackerApp :)
		gps.updateLocation(75.345, 65.123);
		gps.updateLocation(54.345, 78.123);
		*/
		
		// Anonymous Class Implementation
		/*LocationListener listener = new LocationListener() {
			@Override
			public void onLocationChanged(double latitude, double longitude) {
				System.out.println("Location Changed to: "+latitude + " | "+longitude);
			}
		};*/
		
		// Lambda Expression
		// Which works only for the Functional Interfaces
		LocationListener listener = (double latitude, double longitude) -> {
			System.out.println("Location Changed to: "+latitude + " | "+longitude);
		};
		
		GPS gps = new GPS();
		gps.registerForLocationUpdates(listener);
		
		gps.updateLocation(75.345, 65.123);
		gps.updateLocation(54.345, 78.123);
		
		Email email = (String from, String to) -> {
			String message = "Email Sent From "+from+" To "+to;
			return message;
		};
		
		String message = email.sendEmail("john@example.com", "fionna@example.com");
		System.out.println(message);

	}

}
