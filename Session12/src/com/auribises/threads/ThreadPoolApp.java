package com.auribises.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Use Case:
// On the Airport, we have multiple check in counters, where traveller ticket is scanned may be and we put the entry that traveller has checked in 

class AirlineTicket{
	
	static int ticketCount = 0;
	
	String pnr;
	String name;
	int seatNumber;
	boolean chekcedIn;
	
	public AirlineTicket() {
		
	}
	
	public AirlineTicket(String pnr, String name) {
		this.pnr = pnr;
		this.name = name;
		seatNumber = 0;
		chekcedIn = false;
	}

	@Override
	public String toString() {
		return "AirlineTicket [pnr=" + pnr + ", name=" + name + ", seatNumber=" + seatNumber + ", chekcedIn="
				+ chekcedIn + "]";
	}
	
}

/*class CheckInTask implements Runnable{
	
	AirlineTicket ticket;
	
	CheckInTask(AirlineTicket ticket){
		this.ticket = ticket;
	}
	
	public void run() {
		// Checking the User in may be a long running operation and hence we have done it through threads
		System.out.println("Checking In "+ticket.name);
		System.out.println("Updating Check In Task");
		ticket.chekcedIn = true;
		System.out.println("Allocating Seat Number");
		ticket.seatNumber = ++AirlineTicket.ticketCount;
		System.out.println("Check In Porcess Finsihed: "+ticket.name+" has been allocated seat#"+ticket.seatNumber);
	}
	
}*/

class CheckInTask implements Callable<String>{
	
	AirlineTicket ticket;
	
	CheckInTask(AirlineTicket ticket){
		this.ticket = ticket;
	}
	
	public String call() throws Exception{
		// Checking the User in may be a long running operation and hence we have done it through threads
		//System.out.println("Checking In "+ticket.name);
		//System.out.println("Updating Check In Task");
		ticket.chekcedIn = true;
		//System.out.println("Allocating Seat Number");
		ticket.seatNumber = ++AirlineTicket.ticketCount;
		//System.out.println("Check In Porcess Finsihed: "+ticket.name+" has been allocated seat#"+ticket.seatNumber);
		
		return ticket.name+" with PNR "+ticket.pnr+" has been allocated seat number #"+ticket.seatNumber+" and is Checked IN";
		
	}
	
}

public class ThreadPoolApp {

	public static void main(String[] args) {
		
		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.println("Processors: "+Runtime.getRuntime().availableProcessors());
		System.out.println("~~~~~~~~~~~~~~~~");
		
		AirlineTicket ticket1 = new AirlineTicket("ABF123", "John");
		AirlineTicket ticket2 = new AirlineTicket("PQF345", "Fionna");
		AirlineTicket ticket3 = new AirlineTicket("BBC433", "Dave");
		AirlineTicket ticket4 = new AirlineTicket("DEA112", "Kim");
		AirlineTicket ticket5 = new AirlineTicket("FKL789", "Ana");
		
		System.out.println(ticket1);
		System.out.println(ticket2);
		System.out.println(ticket3);
		System.out.println(ticket4);
		System.out.println(ticket5);
		
//		Runnable r1 = new CheckInTask(ticket1);
//		Thread t1 = new Thread(r1);
//		t1.start();
		

//		new Thread(new CheckInTask(ticket1)).start();
//		new Thread(new CheckInTask(ticket2)).start();
//		new Thread(new CheckInTask(ticket3)).start();
//		new Thread(new CheckInTask(ticket4)).start();
//		new Thread(new CheckInTask(ticket5)).start();
		
		/*Runnable task1 = new CheckInTask(ticket1);
		Runnable task2 = new CheckInTask(ticket2);
		Runnable task3 = new CheckInTask(ticket3);
		Runnable task4 = new CheckInTask(ticket4);
		Runnable task5 = new CheckInTask(ticket5);*/
		
		
		// Challenge:
		// We will create 5 Threads and all of them shall be executed parallel :)
		// If we execute n-number of threads all together, we are making the available processors to be occupied fully
		
		// Solution:
		// We can create a Thread Pool
		// Thread Pool will take number of cores and will work accordingly for efficient usage
		ExecutorService service = Executors.newFixedThreadPool(2); // 2 must be a number as compared to what you have in overall available processros
		
		/*service.execute(task1);
		service.execute(task2);
		service.execute(task3);
		service.execute(task4);
		service.execute(task5);
		
		// Now, we will use only 2 processors i.e. cores to execute multiple threads
		 */
		
		Callable task1 = new CheckInTask(ticket1);
		Callable task2 = new CheckInTask(ticket2);
		Callable task3 = new CheckInTask(ticket3);
		Callable task4 = new CheckInTask(ticket4);
		Callable task5 = new CheckInTask(ticket5);
		
		Future<String> future1 = service.submit(task1);
		Future<String> future2 = service.submit(task2);
		Future<String> future3 = service.submit(task3);
		Future<String> future4 = service.submit(task4);
		Future<String> future5 = service.submit(task5);
		
		try {
			System.out.println(future1.get());	// get function execution is blocking instruction i.e. below statements will not execute till this has finished its execution
			System.out.println(future2.get());
			System.out.println(future3.get());
			System.out.println(future4.get());
			System.out.println(future5.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		service.shutdown(); // release the resources

	}

}
