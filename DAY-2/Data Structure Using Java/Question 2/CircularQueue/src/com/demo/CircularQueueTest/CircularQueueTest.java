package com.demo.CircularQueueTest;

import java.util.Scanner;

import com.demo.CircularQueue.CircularQueue;

public class CircularQueueTest {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueue cq = new CircularQueue();
		int choice, data;
		
		do {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if Empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
            case 1:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                cq.enqueue(data);
                break;
            case 2:
                cq.dequeue();
                break;
            case 3:
                cq.peek();
                break;
            case 4:
                cq.display();
                break;
            case 5:
                System.out.println("Queue empty: " + cq.isEmpty());
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice!");
        }
		}while(choice!=6);
		sc.close();
	}
}
