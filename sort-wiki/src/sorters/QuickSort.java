package sorters;

/*
 * File: QuickSort.java
 * Author: Logan Pageler
 * Purpose: Implements the sorting algorithm QuickSort.
 * Class: CSC 345
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to sort an array using quick sort algorithm.
 * 
 * @author Logan Pageler
 */
public class QuickSort {

    /**
     * Sorts an array using Quick sort. Note:
     * This is done in place so param arr will
     * be changes. Returns the state of the array
     * after each cycle
     * 
     * @param arr array to sort
     * @return list of all array states
     */
    public static List<int[]> sort(int[] arr) {
        List<int[]> list = new ArrayList<int[]>();
        list.add(Arrays.copyOf(arr, arr.length));
        partition(arr, 0, arr.length, list);
        return list;
    }

    /**
     * partitions a given subarray around a selected pivot
     * 
     * @param arr,   array of inegers that needs to be sorted
     * @param start, the first index of the subarray
     * @param end,   the last index of the subarray
     * @param list,  used for saving array order snapshots
     */
    private static void partition(int[] arr, int start, int end, List<int[]> list) {
        if (end - start <= 1)
            return;
        int pivotPos = (int) (Math.random() * (end - start) + start);
        int pivot = arr[pivotPos];
        int val2;
        int i = start;
        if (i == pivotPos)
            i++;
        for (int j = start; j < end; j++) {
            if ((val2 = arr[j]) <= pivot && j != pivotPos) {
                if (i != j) {
                    arr[j] = arr[i];
                    arr[i] = val2;
                }
                i++;
                if (i == pivotPos)
                    i++;
            }
            list.add(Arrays.copyOf(arr, arr.length));
        }
        if (i < pivotPos) {
            arr[pivotPos] = arr[i];
            arr[i] = pivot;
            list.add(Arrays.copyOf(arr, arr.length));
        } else if (i > pivotPos) {
            i--;
            arr[pivotPos] = arr[i];
            arr[i] = pivot;
            list.add(Arrays.copyOf(arr, arr.length));
        }
        partition(arr, start, i, list);
        partition(arr, i + 1, end, list);
    }
}
