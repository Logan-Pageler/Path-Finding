package sorters;

/*
 * File: InsertionSort.java
 * Author: Michelle Ramos Hernandez
 * Purpose: Implements the sorting algorithm Insertion Sort.
 * Class: CSC 345
 */

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    
    /**
	 * uses the Insertion sort algorithm to sort integers in an array in an
	 * accedning order.
	 * @param array, array of integers, the array that will be sorted
	 * @param i,     integer, starting value
	 * @param j,     integer, ending value
	 */
	public static void insertion(int[] arr, int i, int j) {
		ArrayList<int[]> list = new ArrayList<>();
		for (int k = i; k < j + 1; k++) {
			int current = arr[k];
			int m = k - 1;
			// swaps arrays as needed
			while (m >= i && arr[m] > current) {
				arr[m + 1] = arr[m];
				m = m - 1;
			}
			arr[m + 1] = current;
			list.add(Arrays.copyOf(arr, arr.length));
		}
	}
}
