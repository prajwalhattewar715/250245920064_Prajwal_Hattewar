package com.demo.CircularLinkedList;
import com.demo.Node.*;


public class CircularLinkedList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	
	// insert new node at 'n' th position
	
	public void insertAt(int data,int position) {
		Node newNode = new Node(data);
		
		if(position < 1 || position > size +1) {
			System.out.println("Invalid position");
			return;
		}
		
		if(head==null) {
			// if list is empty
			head = newNode;
			tail = newNode;
			tail.next=head;	
		}
		else {
			Node temp = head;
			for(int i=1;i<position-1;i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			
			if(temp == tail) {
				tail = newNode;
				tail.next = head;
			}
		}
		
		size++;
		System.out.println("Node inserted at position" + position);
	}
	
	// Delete node according to data
	public void deleteByData(int data) {
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		Node current = head, prev = tail;
		boolean found = false;
		do {
			if(current.data == data) {
				found = true;
				
				// delete head node
				if(current == head) {
					head = head.next;
					tail.next = head;
				}
				// delete tail node
				else if(current == tail) {
					tail = prev;
					tail.next = head;
				}
				else {
					prev.next = current.next;
				}
				size--;
				System.out.println("Node with data" + data + "deleted");
				return;
			}
			prev = current;
			current = current.next;
		}while(current != head);
		
		if(!found) {
			System.out.println("Data not found in the list");
		}	
	}
	
	// modify node( ask data from user )
	public void modifyNode(int oldData, int newData) {
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		Node temp = head;
		boolean found = false;
		
		do {
			if(temp.data == oldData) {
				temp.data = newData;
				found = true;
				System.out.println("Node modified from " + oldData + "to" + newData);
				return;
			}
			temp = temp.next;
		}while(temp != head);
		
		if(!found) {
			System.out.println("Data not found in the list");
		}
	}
	
	//Display
	public void display() {
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		Node temp = head;
		System.out.println("ciruclar linked list");
		do {
			System.out.print(temp.data + " ->");
			temp = temp.next;
			
		}while(temp !=head);
		System.out.println(" back to head ");
	}
}
