package com.demo.test;

import java.util.Scanner;

import com.demo.CircularLinkedList.CircularLinkedList;

public class CircularLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cll = new CircularLinkedList();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			 System.out.println("\n Circular Linked List Menu ");
	         System.out.println("1. Insert at Nth position");
	         System.out.println("2. Delete by Data");
	         System.out.println("3. Modify Node");
	         System.out.println("4. Display");
	         System.out.println("5. Exit");
	         System.out.print("Enter your choice: ");
	         choice = sc.nextInt();
	         
	         switch(choice) {
	         case 1:
	        	 System.out.print("Enter data: ");
                 int data = sc.nextInt();
                 System.out.print("Enter position: ");
                 int pos = sc.nextInt();
                 cll.insertAt(data, pos);
	        	 break;
	         case 2:
	        	 System.out.print("Enter data to delete: ");
                 int delData = sc.nextInt();
                 cll.deleteByData(delData);
	        	 break;
	         case 3:
	        	 System.out.print("Enter old data: ");
                 int oldData = sc.nextInt();
                 System.out.print("Enter new data: ");
                 int newData = sc.nextInt();
                 cll.modifyNode(oldData, newData);
	        	 break;
	         case 4:
	        	 cll.display();
	        	 break;
	         case 5:
	        	 System.out.println("Exiting..");
	        	 break;
	        default:
	        	System.out.println("invalid choice");
	         }
		}while(choice != 5);
		sc.close();
	}

}
