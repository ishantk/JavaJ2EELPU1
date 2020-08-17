package com.auribises.io;

// T can represent any data type
// But it has to be reference type and not primitive :)

class Point<T, U>{
	
	/*int x;
	int y;*/
	
	T x;
	T y;
	
	U z;
	
	Point(){
		x = null;
		y = null;
		z = null;
	}
	
	Point(T x, T y, U z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//@Override is an annotation and being used just like a comment here
	@Override 
	public String toString() {
		return "Point is: "+x+" : "+y+" : "+z;
	}
	
}

public class Generics {

	public static void main(String[] args) {
		
		/*
		Point<Integer> p1 = new Point<Integer>(10, 20);
		Point<Double> p2 = new Point<Double>(10.1, 20.2);
		Point<String> p3 = new Point<String>("A", "B");*/
		
		Point<Integer, Double> p1 = new Point<Integer, Double>(10, 20, 2.2);
		Point<Double, String> p2 = new Point<Double, String>(10.1, 20.2, "A");
		Point<String, Integer> p3 = new Point<String, Integer>("A", "B", 1);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
