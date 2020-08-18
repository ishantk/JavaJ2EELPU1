package com.auribises.threads;

class MovieTicket{
	
	String title;
	int seatNumber;
	
	String email;
	
	
	public MovieTicket() {
	
	}
	
	public MovieTicket(String title, int seatNumber) {
		//email = ""; // by default lets make it empty
		this.title = title;
		this.seatNumber = seatNumber;
	}
	
	void blockMovieTicket(String email) {
		this.email = email;
		System.out.println("We have Blocked Ticket for You "+email);
	}
	
	void pay() {
		System.out.println("Please Pay \u20b9"+200);
		System.out.println("Thank You "+email+" Your Ticket has been Booked");
	}
	
	void showConfirmedTicket() {
		System.out.println("Dear, "+email);
		System.out.println("Your Confirmed Ticket Details: "+title+" "+seatNumber);
	}
	
	boolean isTicketAvailable() {
		//return email.isEmpty();
		return email == null;
	}
}

// Whenever we have a long running operations we must put in a separate thread
class MovieTicketTransaction extends Thread{
	
	String email;
	MovieTicket ticket;
	
	MovieTicketTransaction(String email, MovieTicket ticket){
		this.email = email;
		this.ticket = ticket;
	}
	
	public void run() {
		
		// if any thread is using ticket object, it will be locked for the same thread, and all other threads must wait
		// till sync block has not exited, no other thread can use the same ticket object :)
		synchronized (ticket) {
			// isTicketAvailable is a HACK
			// Could be a case for n-number of users, isTicketAvailble may return true
			if(ticket.isTicketAvailable()) {
				
				try {
					System.out.println("Validating User "+email+" for his account detials in the background");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				ticket.blockMovieTicket(email);
				ticket.pay();
				ticket.showConfirmedTicket();
			}else {
				System.out.println("Sorry, "+email+" ticket is booked :(");
			}
		}
	}
}

class User{
	
	String name;
	String phone;
	String email;
	
	public User() {
		
	}
	
	public User(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	void selectAndBookMovieTicket(MovieTicket ticket) {
		MovieTicketTransaction transaction = new MovieTicketTransaction(email, ticket);
		transaction.start();
	}
	
}

public class Synchronization {

	public static void main(String[] args) {
		
		MovieTicket m1 = new MovieTicket("Avengers", 1);
		MovieTicket m2 = new MovieTicket("Avengers", 2);
		MovieTicket m3 = new MovieTicket("Avengers", 3);
		MovieTicket m4 = new MovieTicket("Avengers", 4);
		MovieTicket m5 = new MovieTicket("Avengers", 5);
		
		//System.out.println("Is Seat Number #"+m1.seatNumber+" available: "+m1.isTicketAvailable());
		
		User user1 = new User("John", "+91 99999 88888", "john@example.com");
		User user2 = new User("Fionna", "+91 99999 11111", "fionna@example.com");
		
		user1.selectAndBookMovieTicket(m1);
		user2.selectAndBookMovieTicket(m1);
		
	}

}

// Challenge: In a Multi Threaded Env, when Multiple Threads access the Same Object, we must sync them
// Assignment: Write a Program demonstrating the usage of synchorized method 

