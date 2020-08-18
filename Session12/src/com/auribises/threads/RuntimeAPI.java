package com.auribises.threads;

class Student{
	
	int roll;
	String name;
	
	Student(){
		System.out.println("Student Object Constructed");
	}
	
	Student(int roll, String name){
		System.out.println("Student Object Constructed with roll: "+roll+" and name: "+name);
	}
	
	// finalize is a protected function in Object class which we can Override
	// It is executed whenever object is removed from memory
	@Override
	protected void finalize() throws Throwable { // acts as a destructor
		System.out.println("Student Object Removed: "+roll+" "+name);
	}
}

public class RuntimeAPI {

	public static void main(String[] args) {
		
		Student s1 = new Student(101, "John");
		Student s2 = new Student(201, "Jennie");
		Student s3 = new Student(301, "Jack");
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("Max Memory: "+runtime.maxMemory());
		System.out.println("Free Memory: "+runtime.freeMemory());
		System.out.println("Total Memory: "+runtime.totalMemory());

		// When we have references pointing to null, so the objects which have no reference will be available
		// to Garbage Collector to be removed from memory :)
		s1 = null;
		s2 = null;
		s3 = null;
		
		System.out.println("Executing Garbage Collector");
		// Execute GC
		runtime.gc();
		//System.gc();
		
		
		System.out.println("Max Memory: "+runtime.maxMemory());
		System.out.println("Free Memory: "+runtime.freeMemory());
		System.out.println("Total Memory: "+runtime.totalMemory());
		

	}

}
