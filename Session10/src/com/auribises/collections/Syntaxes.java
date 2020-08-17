package com.auribises.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Syntaxes {

	public static void main(String[] args) {
		
		// Direct Object Construction
		LinkedList list = new LinkedList();
		ArrayList aList = new ArrayList();
		Vector vector = new Vector();
		Stack stack = new Stack(); // For you to explore | LIFO
		
		// Polymorhic Statements
		List ref = new LinkedList();
		ref = new ArrayList();
		ref = new Vector();
		ref = new Stack();
		
		// And Hence for Others Also :)

	}

}
