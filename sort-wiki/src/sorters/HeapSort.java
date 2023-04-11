package sorters;

/*
 * File: HeapSort.java
 * Author: Michelle Ramos Hernandez
 * Purpose: Implements the sorting algorithm Heap Sort.
 * Class: CSC 345
 */

import java.util.ArrayList;
import java.util.Arrays;

public class HeapSort {

	public static ArrayList<int[]> sort(int[] array) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(Arrays.copyOf(array, array.length));
		int k = (int)Math.floor(array.length/2);
		
		for(int i = k; i > 0; i--)
			bubbleDown(list, array, i, array.length-1);
		
		int count = array.length-1;
		for(int i = 1; i < array.length; i++) {
			while(count > 0) { 
				swap(array, 1, count);
				bubbleDown(list, array, 1, count-i);
				count--; 
			}	
		}
		list.add(Arrays.copyOfRange(array, 1, array.length));
		return list;
	}

	/**
	 * bubbles down the chosen index element to its proper position
	 * according to max heap order.
	 * @param array, array of integers that will be used to swap the arrays
	 * @param i, starting index that needs to be bubbled down to make inot heap order
	 */
	private static void bubbleDown(ArrayList<int[]> list, int[] array, int i, int stop) {
		if (left(i) <= stop) {
			// find higher priority child
			int higherpriorityChild = left(i);
			if (right(i) <= stop && compareTo(array, array[left(i)], array[right(i)]) < 0)
				higherpriorityChild = right(i);
			// check if we need to swap
			if (compareTo(array, array[i], array[higherpriorityChild]) < 0) {
				// swap with child of higher priority
				swap(array, i, higherpriorityChild);
				list.add(Arrays.copyOfRange(array, 1, array.length));
				// recurse
				bubbleDown(list, array, higherpriorityChild, stop);
			}
		}
	}

	/**
	 * swaps two arrays in an array
	 * @param i,     first index that needs to be swapped
	 * @param j,     the second index that needs to be swaped
	 * @param array, array of integers that will be used to swap the arrays
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	/**
	 * compares if two elemts are larger than teh other
	 * @param array, array of integers that will be used to swap the arrays
	 * @param left,  the index of the left child
	 * @param right, the index of teh right child
	 * @return -1 if the left child is larger, and 1 if the right child is larger
	 */
	public static int compareTo(int[] array, int left, int right) {
		if (left > right) {
			return 1;
		}
		return -1;
	}

	/**
	 * finds the left child of the parent
	 * @param i, int the index of where the current patient is in the array
	 * @return int, the left child of the parents index
	 */
	private static int left(int i) {
		return 2 * i;
	}

	/**
	 * finds the right child of the parent
	 * @param i, int the index of where the current patient is in the array
	 * @return int, the right child of the parents index
	 */
	private static int right(int i) {
		return (2 * i) + 1;
	}
}
