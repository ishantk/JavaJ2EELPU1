package com.auribises.misc;

public class LocalFunctions {

	class CA{
		
	}
	
	interface Inf{
		
	}
	
	static class CB{
		
	}
	
	static interface Jnf{
		
	}
	
	void hello() {
		
		// class within a function => Local Classes
		class CC{
			
		}
		
		// error => Local Functions
		/*void heya() {
			
		}*/
		
		/* error => Local Interface
		interface Knf{
			
		}*/
		
	}
	
	static void hi() {
		
		// by default class CD is static
		class CD{
			
		}
		
		
	}
	
	public static void main(String[] args) {
		

	}

}
