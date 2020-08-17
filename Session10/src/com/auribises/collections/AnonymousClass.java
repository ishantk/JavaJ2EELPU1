package com.auribises.collections;

interface Notification{
	void notify(String message);
}

class User implements Notification{
	
	public void notify(String message) {
		System.out.println("Notifcation Received: "+message);
	}
}

public class AnonymousClass {

	public static void main(String[] args) {
		
		Notification ref = new User();
		ref.notify("This is all for the Day");
		
		
		// AnonymousClass
		Notification notification = new Notification() {
			
			public void notify(String message) {
				System.out.println("Notifcation Received Anonymously: "+message);
			}
		};

		notification.notify("Thank You All :) ");
		
	}

}
