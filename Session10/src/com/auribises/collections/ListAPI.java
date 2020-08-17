package com.auribises.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.auribises.model.Song;

class DurationComparator implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		if(o1.duration == o2.duration) {
			return 0;
		}else if(o1.duration > o2.duration) {
			return 1;
		}else {
			return -1;
		}
	}
	
}

class NamedComparator implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		return o1.title.compareTo(o2.title);
	}
	
}

public class ListAPI {

	public static void main(String[] args) {

		// Hetro | list1 can store any type of data
		LinkedList list1 = new LinkedList();
		
		// Homo | list2 can store only String and list3 can store only Song
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<Song> list3 = new LinkedList<Song>();
		
		Song song1 = new Song("Party All Night", "Honey Singh", 4.5);
		Song song2 = new Song("High Heels", "Honey Singh", 4.5);
		Song song3 = new Song("Sunny Sunny", "Honey Singh", 6.5);
		Song song4 = new Song("Blue Eyes", "Honey Singh", 8.5);
		Song song5 = new Song("Urvashi", "Honey Singh", 2.5);
		
		
		// 1. Adding Data to List
		list1.add(10);		// 0
		list1.add('A');
		list1.add("John");
		list1.add(song1);
		list1.add(2.2);	    // n-1
		
		//list2.add(10);		// error
		list2.add("John");	// 0
		list2.add("Fionna");
		list2.add("Jennie");
		list2.add("Jack");
		list2.add("Leo");
		list2.add("Kim");
		list2.add("Sia");	// n-1
		
		//list3.add("John");  // error
		list3.add(song1);
		list3.add(song2);
		list3.add(song3);
		list3.add(song4);
		list3.add(song5);
		
		// 2. Printing LinkedList
		System.out.println("list1 is:");
		System.out.println(list1);
		
		System.out.println();
		
		System.out.println("list2 is:");
		System.out.println(list2);
		
		System.out.println();
		
		System.out.println("list3 is:");
		System.out.println(list3);
		
		System.out.println();
		
		// 3. Size of the list
		System.out.println("list1 size is: "+list1.size());
		System.out.println("list2 size is: "+list2.size());
		System.out.println("list3 size is: "+list3.size());
		
		System.out.println();
		
		// 4. Read Single Element from the List
		System.out.println(list1.get(0));
		System.out.println(list2.get(1));
		System.out.println(list3.get(2));
		
		// 5. Remove data from List
		list1.remove(0);
		list2.remove(1);
		list3.remove(2);
		// Index Shifting happens automatically for us :)
		
		System.out.println("list1 size is: "+list1.size());
		System.out.println("list2 size is: "+list2.size());
		System.out.println("list3 size is: "+list3.size());
		
		// 6. Remove all elements from list
		//list1.clear();
		
		
		// 7. Containment
		if(list2.contains("Leo")) {
			System.out.println("Leo Found");
		}
		
		if(list3.contains(song4)) {
			System.out.println("song4 Found: "+song4);
		}
		System.out.println();

		// 8. Update Operation
		System.out.println("list2 is: "+list2);
		list2.set(2, "Dave Watson");
		System.out.println("list2 now is: "+list2);

		// 9. Index Search
		int idx = list2.indexOf("Dave Watson");
		System.out.println("idx of Dave Watson is: "+idx);
		
		// 10. Merging Lists
		LinkedList<String> names = new LinkedList<String>();
		names.add("Harry");
		names.add("George");
		names.add("Tim");
		
		names.addAll(list2); // Add All elements form list2 into names
		System.out.println("names: "+names);
		
		System.out.println();
		
		
		// 11. Iterate in LinkedList
		System.out.println("1. Iterating with For Loop");
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		System.out.println();
		for(int i=0;i<list3.size();i++) {
			System.out.println(list3.get(i));
		}
		
		System.out.println();
		System.out.println("2. Iterating with Enhanced For Loop");
		System.out.println();
		for(Object element : list1) {
			System.out.println(element);
		}
		
		for(String name : list2) {
			System.out.println(name);
		}
		System.out.println();
		for(Song song : list3) {
			System.out.println(song);
		}
		
		System.out.println();
		System.out.println("3. Iterator API");
		System.out.println();
		
		Iterator itr1 = list1.iterator();
		Iterator<String> itr2 = list2.iterator();
		Iterator<Song> itr3 = list3.iterator();
		/*
		System.out.println(itr1.next());
		System.out.println(itr1.next());*/
		
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		System.out.println();
		while(itr2.hasNext()) {
			String name = itr2.next();
			System.out.println(name);
			if(name.equals("John")) {
				itr2.remove(); // removes the element from the List
			}
		}
		System.out.println();
		while(itr3.hasNext()) {
			System.out.println(itr3.next());
		}
		
		System.out.println("list2 now is: "+list2);
		
		System.out.println();
		System.out.println("4. ListIterator API");
		ListIterator listItr2 = list2.listIterator();
		while(listItr2.hasNext()) {
			System.out.println(listItr2.next());
		}
		System.out.println("------");
		while(listItr2.hasPrevious()) {
			System.out.println(listItr2.previous());
		}
		
		System.out.println();
		System.out.println("5. Enumeration");
		
		// With Enumeration we can only navigate and cannot remove
		Enumeration<String> enm = Collections.enumeration(list2);
		while(enm.hasMoreElements()) {
			System.out.println(enm.nextElement());
		}
		
		
		System.out.println();
		System.out.println();
		
		for(Song song : list3) {
			System.out.println("-----------");
			System.out.println(song);
			System.out.println("-----------");
		}
		
		//Collections.sort(list3); // For List with customized object like Song, we must implement Comparable : )
	
		//Collections.sort(list3, new DurationComparator());
		Collections.sort(list3, new NamedComparator());
		
		System.out.println();
		System.out.println();
		
		for(Song song : list3) {
			System.out.println("-----------");
			System.out.println(song);
			System.out.println("-----------");
		}
		
	}

}
