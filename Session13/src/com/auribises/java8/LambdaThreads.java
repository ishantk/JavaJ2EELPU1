package com.auribises.java8;


class PrintTask implements Runnable{
	@Override
	public void run() {
		
		for(int i=1;i<=10;i++) {
			System.out.println("Printing *LearningJava.pdf* Copy#"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}


public class LambdaThreads {

	public static void main(String[] args) {
		System.out.println("Main Started");
		
		//Runnable r = new PrintTask();
		//Thread th = new Thread(r);
		//th.start();
		
		//new Thread(new PrintTask()).start();
		
		/*Runnable r = () -> {
			
			for(int i=1;i<=10;i++) {
				System.out.println("Printing *LearningJava.pdf* Copy#"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(r).start();*/
		
		new Thread( () -> {
			
			for(int i=1;i<=10;i++) {
				System.out.println("Printing *LearningJava.pdf* Copy#"+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		System.out.println("Main Finished");
	}

}
