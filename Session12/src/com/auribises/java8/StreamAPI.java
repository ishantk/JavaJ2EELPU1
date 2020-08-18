package com.auribises.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
	
	// numbers is a reference variable which will refer to an Array 
	static void add(int... numbers) { // ... spread operator
		
	}
	
	public static void main(String[] args) {

		StreamAPI.add(10, 20, 30);
		StreamAPI.add(10, 20, 30, 40, 50);
		StreamAPI.add(10, 20, 30, 40, 50, 60, 70, 80);
		
		
		// Stream API in Java processes the Objects in the Collections eg: in ArrayList
		// we got functions like map, filter and reduce which are very useful to perform operations on Collections
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(list1);
		System.out.println(list1.getClass().getSimpleName()+" "+list1.size());
		
		/*
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<list1.size();i++) {
			list2.add(list1.get(i) * list1.get(i)); // list1.get(i) * list1.get(i) is suppose to be performed on every single lement
		}
		
		System.out.println(list1);
		System.out.println("list1 size is: "+list1.size());
		System.out.println();
		System.out.println(list2);
		System.out.println("list2 size is: "+list1.size());*/
		
		// 1. Stream API -> map | Map a function on our data and generate new data accordingly
		//Stream<Integer> stream = list1.stream();
		//stream = stream.map(x->x*x); // x->x*x | Lambda Expression :)
		//stream.collect(Collectors.toList());
		
		List<Integer> list2 = (List<Integer>)list1.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(list2.getClass().getSimpleName()+" "+list2.size());
		
		// Stream API map with enhanced for loop
		list1.stream().map(x->x*x).forEach(y->System.out.println(y));
		
		System.out.println();
		
		// 2. Stream API -> filter | filter maps a function on our data and generate new data filtered as per the inputs
		List<String> contactNames = Arrays.asList("Anna", "Kia", "Jennie", "Jen", "Anika", "Lee", "Sia", "John", "Kim");
		System.out.println("All Contact Names");
		System.out.println(contactNames);
		
		System.out.println("Names Starting with Je");
		List<String> filteredNames = (List<String>)contactNames.stream().filter(s->s.startsWith("Je")).collect(Collectors.toList());
		System.out.println(filteredNames);
		
		System.out.println();
		
		List<String> textMessages = Arrays.asList("Hello", "hello Again", "This is hello from Kia", "Bye", "Nice to see yours");
		System.out.println("Text Messages:");
		System.out.println(textMessages);
		
		List<String> filteredTexts = (List<String>)textMessages.stream().filter(s->s.contains("hello")).collect(Collectors.toList());
		System.out.println("Filtered Messages:");
		System.out.println(filteredTexts);
		
		List<String> sortedTexts = textMessages.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Messages:");
		System.out.println(sortedTexts);
		
		// Assignment: Write an implementation of reduce function
		//list1.stream().reduce()  :)
		
	}

}
