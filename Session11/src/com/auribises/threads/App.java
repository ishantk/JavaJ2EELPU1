package com.auribises.threads;

/*
class PrintTask{
	
	void printDocument() {
		for(int i=1;i<=10;i++) {
			System.out.println("Printing @LearningPython.pdf@ Copy# "+i);
		}
	}
}
*/

class PrintTask1 extends Thread{
	
	// run is overrided from Thread class
	// because Child Thread can only execute the statements written in the run method parallely to the main
	public void run() {
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Printing @LearningPython.pdf@ Copy# "+i);
		}
	}
}

class CA{
	
}

//class PrintTask2 extends CA, Thread{ // Multiple Inheritance isnt supported
class PrintTask2 extends CA implements Runnable{
	
	// run is overrided from Runnable Interface
	public void run() {
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Printing ^LearningFlutter.pdf@ Copy^ "+i);
		}
	}
}

public class App {

	// main method below, represents tasks which we write as in instructions
	// these tasks will be executed in a sequence
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		
		PrintTask1 task = new PrintTask1();
		Runnable r = new PrintTask2(); // Polymorphic Statement
		
		Thread th = new Thread(r);     // Pass Runnable reference to the constructor of thread :)
		
		task.setName("Python");
		th.setName("Flutter");
		Thread.currentThread().setName("Java");
		
		task.setPriority(Thread.MAX_PRIORITY); // 10
		th.setPriority(Thread.MIN_PRIORITY);   // 1
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);   // 5 | -> By default every thread has NORM_PRIORITY
		
		// Remember -> setting up the priority is for JVM in its low memory conditions or when JVM is highly occupied
		
		System.out.println("State of task is: "+task.getState());
		System.out.println("State of th is: "+th.getState());
		System.out.println("State of main is: "+Thread.currentThread().getState());
		
		//task.printDocument();
		//task.run(); // We should not start a thread by executing run function directly
		task.start(); // start method will internally execute the run method
		// For thread to Work parallel to the main thread, we have states of the Child thread
		// States of the Child thread are managed with some other built in functions, and hence we must execute start function
		
		
		// Immediately after we start the task, we will execute join
		try {
			task.join(); // Execute my Tasks first and let other wait
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
	
		th.start();
		
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Printing *LearningJava.pdf* Copy# "+i);
		}
		
		System.out.println("task name is: "+task.getName()+" Priority: "+task.getPriority());
		System.out.println("th name is: "+th.getName()+" Priority: "+th.getPriority());
		System.out.println("main name is: "+Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority());
		
		
		System.out.println("Main Finished");

	}

}

// States of a Thread:
// 1. NEW			-> When an object of Thread is constructed
// 2. RUNNABLE 		-> When thread is running
// 3. TERMINATED 	-> When thread is finished
// 4. WATING/TIMED-WATINIG -> When we have made our thread to wait i.e. suspend its execution for some event for some time
// 5. BLOCKED -> Thread is blocked and it is not executing [dead-lock]
