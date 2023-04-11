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
	 * Sorts an array using insertion sort. Note:
	 * This is done in place so param arr will
	 * be changes. Returns the state of the array
	 * after each cycle
	 * 
	 * @param arr array to sort
	 * @return list of all array states
	 */
	public static ArrayList<int[]> sort(int[] array) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(Arrays.copyOf(array, array.length));
		int n = array.length;
		for (int i = 1; i < n; i++) {
			int val = array[i];
			int j = i - 1;
			int comp = array[j];
			while (j >= 0 && comp > val) {
				array[j + 1] = comp;
				j--;
				if (j >= 0)
					comp = array[j];
				list.add(Arrays.copyOf(array, array.length));
			}
			array[j + 1] = val;
		}
		list.add(Arrays.copyOf(array, array.length));
		return list;
	}
}
