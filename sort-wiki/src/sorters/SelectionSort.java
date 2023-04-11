package sorters;

/*
 * File: SelectionSort.java
 * Author: Michelle Ramos Hernandez
 * Purpose: Implements the sorting algorithm Selection Sort.
 * Class: CSC 345
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

	/**
	 * Sorts an array using selection sort. Note:
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
		int minIndex = 0;
		for (int i = 0; i < array.length - 1; i++) {
			minIndex = i;
<<<<<<< HEAD
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
=======
			for (int j = i+1; j < array.length; j++) {
				if (array[minIndex] > array[j])
>>>>>>> f4a14953ffcbad2c658d3fdeb8d0016838ce5690
					minIndex = j;
				list.add(Arrays.copyOf(array, array.length));
			}
			swap(array, i, minIndex);
			list.add(Arrays.copyOf(array, array.length));
		}
		return list;
	}

	/**
	 * swaps two arrays in an array
	 * 
	 * @param i,     first index that needs to be swapped
	 * @param j,     the second index that needs to be swaped
	 * @param array, array of integers that will be used to swap the arrays
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
