package com.auribises.io;

public class WrapperClasses {

	public static void main(String[] args) {
		
		// Primitive :)
		// Value Type :) | They hold value
		int number = 10;
		
		// int represented as Integer, Integer is Reference Type i.e. Object
		// Integer here is a Wrapper Class, which is used to represent primitives as objects :)
		
		// BOXING -> int is represented as Integer
		Integer nRef1 = new Integer(number);
		System.out.println("nRef is: "+nRef1); // toString in Integer class is overrided :)
		
		// AUTO BOXING -> implicit statement
		Integer nRef2 = number; // converted by compiler as -> Integer nRef2 = new Integer(number);
		
		// UN BOXING -> extracting int out of Integer Object
		int num1 = nRef1.intValue();
		
		// AUTO UN BOXING -> implicit Statement
		int num2 = nRef2; // -> converted by compiler as ->  int num2 = nRef2.intValue();
		
		/*
		byte -> Byte
		short -> Short
		int -> Integer
		long -> Long
		
		char -> Character
		
		boolean -> Boolean
		
		float -> Float
		double -> Double
		*/
		
		// Java here can be thought of Fully OO Prog Language :)
		// Primitives in Java can be represented as References

	}

}
