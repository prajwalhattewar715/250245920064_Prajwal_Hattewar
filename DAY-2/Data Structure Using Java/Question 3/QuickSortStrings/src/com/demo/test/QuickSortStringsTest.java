package com.demo.test;

import java.util.Scanner;

import com.demo.QuickSortStrings.QuickSortStrings;

public class QuickSortStringsTest {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		QuickSortStrings qss = new QuickSortStrings();
		
		System.out.println("enter number of strings");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[n];
		System.out.println("enter strings: ");
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextLine();
		}
		
		System.out.println(" \n before sorting");
		qss.display(arr);
		
		qss.quickSort(arr, 0, n-1);
		
		System.out.println(" \n after sorting");
		qss.display(arr);
		sc.close();
	}
}
