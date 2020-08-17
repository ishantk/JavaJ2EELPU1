package com.auribises.collections;

import java.util.PriorityQueue;

public class QueueAPI {

	public static void main(String[] args) {
		
		// FIFO -> First In First Out
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=10;i>0;i--) {
			queue.add(i);
		}

		// we have added the data in below sequence:
		// [head]10 9 8 7 6 5 4 3 2 1[tail]
		
		// BUT, PriorityQueue sorts the data :)
		// [head]1 2 3 4 5 6 7 8 9 10[tail]
		
		// peek -> fetch the head of queue
		// poll -> remove the head of queue
		
		/*
		int head = queue.peek();
		System.out.println("head is: "+head);			// 1
		System.out.println("size is: "+queue.size());	// 10
		
		queue.poll();									// remove 1 from queue i.e. the current head
		
		head = queue.peek();
		
		System.out.println("head is: "+head);			// 2
		System.out.println("size is: "+queue.size());	// 9
		*/
		
		for(int i=0;i<queue.size();i++) {
			System.out.println(queue.peek());
			queue.poll(); // size will be reduced by 1
		}
		
		
	}

}
