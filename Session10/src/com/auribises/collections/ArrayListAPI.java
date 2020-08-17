package com.auribises.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

import com.auribises.model.Message;

public class ArrayListAPI {

	public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		
		// THREAD-SAFE i.e. SYNCHRONIZED
		Vector<String> vector = new Vector<String>();
		
		// ArrayList uses -> dynamic Array Data Structure
		// manipulation operation is slower
		// Cannot be used as QUEUE
		arrayList.add("John");	// 0
		arrayList.add("Fionna");
		arrayList.add("Jennie");
		arrayList.add("Jack");
		arrayList.add("Leo");
		arrayList.add("Kim");
		arrayList.add("Sia");	// n-1
		
		
		// Linked List uses -> Doubly LinkedList
		// manipulation operation is faster
		// Can also be used as QUEUE
		linkedList.add("John");	// 0
		linkedList.add("Fionna");
		linkedList.add("Jennie");
		linkedList.add("Jack");
		linkedList.add("Leo");
		linkedList.add("Kim");
		linkedList.add("Anna");
		linkedList.add("Sia");	// n-1
		
		vector.add("John");	// 0
		vector.add("Fionna");
		vector.add("Jennie");
		vector.add("Jack");
		vector.add("Leo");
		vector.add("Kim");
		vector.add("Sia");	// n-1
		
		
		// PS: All the APIs works same with ArrayList and LinkedList
		
		
		ArrayList<Message> chatConversation = new ArrayList<Message>();
		chatConversation.add(new Message("Hey", "9876512345", new Date().toString()));
		chatConversation.add(new Message("This is Harry", "9876512345", new Date().toString()));
		chatConversation.add(new Message("Java is Awesome :)", "9876512345", new Date().toString()));
		
		for(Message message : chatConversation) {
			System.out.println("------------------------");
			System.out.println(message);
			System.out.println("------------------------");
		}
		
		System.out.println(linkedList);
		Collections.sort(linkedList);
		System.out.println(linkedList);
		
	}

}
