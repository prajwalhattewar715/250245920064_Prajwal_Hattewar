package com.demo.QuickSortStrings;

public class QuickSortStrings {
	// function to perform quicksort
	
	public static void quickSort(String [] arr, int low, int high) {
		if(low< high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex -1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}
	
	public static int partition(String [] arr, int low, int high) {
		String pivot = arr[high];
		int i = low - 1;
		
		for(int j = low; j< high; j++) {
			// compare strings lexicographically
			if(arr[j].compareToIgnoreCase(pivot) <=0) {
				i++;
				// swap
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
		
		String temp = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i +1;
	}
	
	// function to display array
	public static void display(String [] arr) {
		for(String str : arr) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
}
