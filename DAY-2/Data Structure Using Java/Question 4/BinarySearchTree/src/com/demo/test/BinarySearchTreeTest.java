package com.demo.test;

import java.util.Scanner;

import com.demo.bst.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String [] args) {
		Scanner sc  = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int choice, value;
		
		do {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Add Node");
            System.out.println("2. Remove Node");
            System.out.println("3. Display Inorder");
            System.out.println("4. Display Preorder");
            System.out.println("5. Display Postorder");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    bst.addNode(value);
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    bst.removeNode(value);
                    break;
                case 3:
                    bst.inorder();
                    break;
                case 4:
                    bst.preorder();
                    break;
                case 5:
                    bst.postorder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
	}
}
