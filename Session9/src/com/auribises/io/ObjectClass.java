package com.auribises.io;

class Student{ // extends Object{
	
	
	public String toString() {
		return "Student Object ";//+super.toString();
	}
	
}

class Teacher{ // extends Object{
	
}

// PS: Any Class either built-in or User Defined, is Child of Object
//     RTP :)

public class ObjectClass {

	public static void main(String[] args) {
	
		// RTP:
		/*
		Object oRef;
		oRef = new Student();
		oRef = new Teacher();
		*/
		
		Student sRef = new Student();
		System.out.println("Class: "+sRef.getClass());
		System.out.println("Class: "+sRef.getClass().getSimpleName());
		
		System.out.println("sRef is: "+sRef);
		System.out.println("HashCode: "+sRef.hashCode());

	}

}
