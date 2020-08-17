package com.auribises.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class SetAPI {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("John");	
		linkedList.add("Fionna");
		linkedList.add("Jennie");
		linkedList.add("Jack");
		linkedList.add("Fionna");
		linkedList.add("Leo");
		linkedList.add("Kim");
		linkedList.add("Anna");
		linkedList.add("Fionna");	// duplicate data supported
		linkedList.add("Sia");	
		
		System.out.println(linkedList);
		
		// This shall not store the data with linked list approach
		// rather use Hashing as algorithm
		// Hence, we cannot access a single element and output is un-ordered
		//HashSet<String> set = new HashSet<String>();
		
		TreeSet<String> set = new TreeSet<String>(); // additionally sorts the data as well
		set.add("John");	
		set.add("Fionna");
		set.add("Jennie");
		set.add("Jack");
		set.add("Fionna");
		set.add("Leo");
		set.add("Kim");
		set.add("Anna");
		set.add("Fionna");	// duplicate data not supported
		set.add("Sia");	
		
		System.out.println(set);
		System.out.println(set.size());
		
		set.remove("Leo");
		//set.clear();
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		

		// Assignemnt: Create a TreeSet of Song Objects, and see if Comparable works or we have to work with Comparator
		
	}

}
