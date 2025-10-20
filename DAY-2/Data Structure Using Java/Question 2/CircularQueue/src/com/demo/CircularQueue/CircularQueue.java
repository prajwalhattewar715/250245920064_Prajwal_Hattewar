package com.demo.CircularQueue;

import com.demo.Node.Node;

public class CircularQueue {
	private Node front = null;
	private Node rear = null;
	
	// Enqueue - insert  at rear
	public void enqueue(int data) {
		Node newNode = new Node(data);
		
		// empty queue
		if(front == null) {
			front = newNode;
			rear = newNode;
			// circular link
			rear.next = front;
		}
		else {
			rear.next = newNode;
			rear = newNode;
			// maintain circular link
			rear.next = front;
		}
		System.out.println("Enqueue" + data);
	}
	
	public void dequeue() {
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		int value;
		// only one node
		if(front == rear) {
			value = front.data;
			front = null;
			rear = null;
		}else {
			value = front.data;
			front = front.next;
			// maintain circular connection
			rear.next = front;
		}
		System.out.println("Dequeued " + value);
	}
	
	// peek - front element
	public void peek() {
		if(front == null) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println("front element" + front.data);
		}
	}
	
	public void display() {
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		Node temp = front;
		System.out.println("circular queue: ");
		do {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}while(temp !=front);
		System.out.println();
	}
	
	// check if queue is empty
	public boolean isEmpty() {
		return front == null;
	}
}
