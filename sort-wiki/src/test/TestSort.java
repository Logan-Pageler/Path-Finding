import java.util.*;
import sorters.*;
/*
 * File: TestSort.java
 * Author: Michelle Ramos Hernandez
 * Purpose: testing sorting algorhimns: 
 * 			Insertion, Selection, Shell, Quick, Bubble, and Heap.
 * Class: CSC 345
 */


public class TestSort {
	private static int[] arrayOne = new int[11];
	private static int[] arrayTwo = new int[51];
	private static int[] arrayThree = new int[101];

	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			test(i);
		}
	}

	/**
	 * sets random values into the chosen array
	 * @param array, array that will contain integers
	 * @param testNum, depeidng on the testNum the values will either start from
	 * index 0 or one.
	 */
	private static void setVals(int[] array, int testNum) {
		Random randint = new Random();
		if (testNum == 3) {
			array[0] = 0;
			for (int i = 1; i < array.length; i++) {
				array[i] = randint.nextInt(1000);
			}
			return;
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i] = randint.nextInt(1000);
			}
		}

	}

	/**
	 * calls other fucntons to test the sorting of diffrent length arrays
	 * @param testNum, verifies which length array will be sorted
	 */
	private static void test(int testNum) {
		if (testNum == 1) {
			testTen();

		} else if (testNum == 2) {
			testFifty();
		} else {
			testhundred();
		}

	}

	/**
	 * tests sorting algorithms with array length 10
	 */
	private static void testTen() {
		System.out.println("-------------length 10-------------");
		setVals(arrayOne, 1);
		InsertionSort.sort(arrayOne);
		isSorted(arrayOne, "insertion");

		setVals(arrayOne, 2);
		SelectionSort.sort(arrayOne);
		isSorted(arrayOne, "selection");

		setVals(arrayOne, 3);
		HeapSort.sort(arrayOne);
		isSorted(arrayOne, "heap");
		
		setVals(arrayOne, 4);
		QuickSort.sort(arrayOne);
		isSorted(arrayOne, "quick");
		
		setVals(arrayOne, 5);
		ShellSort.sort(arrayOne);
		isSorted(arrayOne, "shell");
		
		setVals(arrayOne, 6);
		BubbleSort.sort(arrayOne);
		isSorted(arrayOne, "bubble");
	}

	/**
	 * tests sorting algorithms with array length 50
	 */
	private static void testFifty() {
		System.out.println("-------------length 50-------------");
		setVals(arrayTwo, 1);
		InsertionSort.sort(arrayTwo);
		isSorted(arrayTwo, "insertion");

		setVals(arrayTwo, 2);
		SelectionSort.sort(arrayTwo);
		isSorted(arrayTwo, "selection");

		setVals(arrayTwo, 3);
		HeapSort.sort(arrayTwo);
		isSorted(arrayTwo, "heap");
		
		setVals(arrayTwo, 4);
		QuickSort.sort(arrayTwo);
		isSorted(arrayTwo, "quick");
		
		setVals(arrayTwo, 5);
		ShellSort.sort(arrayTwo);
		isSorted(arrayTwo, "shell");
		
		setVals(arrayTwo, 6);
		BubbleSort.sort(arrayTwo);
		isSorted(arrayTwo, "bubble");
	}
	
	/**
	 * tests sorting algorithms with array length 100
	 */
	private static void testhundred() {
		System.out.println("-------------length 100-------------");
		setVals(arrayThree, 1);
		InsertionSort.sort(arrayThree);
		isSorted(arrayThree, "insertion");

		setVals(arrayThree, 2);
		SelectionSort.sort(arrayThree);
		isSorted(arrayThree, "selection");

		setVals(arrayThree, 3);
		HeapSort.sort(arrayThree);
		isSorted(arrayThree, "heap");
		
		setVals(arrayThree, 4);
		QuickSort.sort(arrayThree);
		isSorted(arrayThree, "quick");
		
		setVals(arrayThree, 5);
		ShellSort.sort(arrayThree);
		isSorted(arrayThree, "shell");
		
		setVals(arrayThree, 6);
		BubbleSort.sort(arrayThree);
		isSorted(arrayThree, "bubble");
	}

	/**
	 * tests if array is in accending order
	 * @param array, array of integers that will be tested
	 * @param testName, which sorting algorithm was used
	 */
	private static void isSorted(int[] array, String testName) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				System.out.println(testName + " test is NOT sorted");
				return;
			}
		}
		System.out.println(testName + " test is sorted");
	}

	/**
	 * prints the array
	 * @param array, array of integers that will be printed
	 */
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("]");
	}

}
