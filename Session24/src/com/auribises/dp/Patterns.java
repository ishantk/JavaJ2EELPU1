package com.auribises.dp;

/*
 	
 	Design Pattern: [ OOPS :) ]
 		We have some defined ways to write programs eg: syntax of language
 		We have defined ways to solve problems through algos eg: sorting/searching/filtering
 		
 		If we have to write software solution we need to design it in a way we can access the components and manage them with ease
 		DP solve some common problems while we write our software solutions
 		Industrial Standard Ways of writing codes :)
 		
 		Creational
 			How we create objects
 			> Singleton
 			> Factory
 			> AbstractFactory
 			> Builder
 			> Prototype
 			
 		Structural
 			How we create and relate some objects to build a better solution
 			> Adapter
 			> Composite
 			> Proxy
 			> Facade
 			> Bridge
 			> Decorator
 			> FlyWeight
 			
 		Behavioural
 			How different objects manages and maintains the state within them
 			> Template
 			> Mediator
 			> Chain Of Responsibility
 			> Strategy
 			> Command
 			> State
 	
 */



public class Patterns {

	public static void main(String[] args) {
		
		/*Connection con1 = new Connection();
		Connection con2 = new Connection();
		Connection con3 = new Connection();*/
		
		Connection con1 = Connection.getConnection();
		Connection con2 = Connection.getConnection();
		Connection con3 = Connection.getConnection();
		
		System.out.println("con1 is:"+con1.hashCode());
		System.out.println("con2 is:"+con2.hashCode());
		System.out.println("con3 is:"+con3.hashCode());

	}

}
