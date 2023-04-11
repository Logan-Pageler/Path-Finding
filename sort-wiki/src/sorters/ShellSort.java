package sorters;

/*
 * File: ShellSort.java
 * Author: Evan Ohme
 * Purpose: Implements the sorting algorithm Shell Sort.
 * Class: CSC 345
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort {
    
    /**
	 * uses the shellsort algorithm to sort integers in an array in an
	 * ascending order.
	 * @param arr, array of inegers that needs to be sorted
	 */
    public static ArrayList<int[]> sort(int[] arr) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(Arrays.copyOf(arr, arr.length));
        int n = arr.length;
        for (int k = n/2; k > 0; k /= 2) {
            for (int i = k; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= k && arr[j-k] > temp; j -= k) {
                    arr[j] = arr[j-k];
                    list.add(Arrays.copyOf(arr, n));
                }
                arr[j] = temp;
                list.add(Arrays.copyOf(arr, n));
            }
        }
        return list;
    }
}
