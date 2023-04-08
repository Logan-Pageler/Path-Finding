package test;

import java.util.Arrays;
import java.util.List;

import sorters.QuickSort;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length * 2);
        }

        List<int[]> list = QuickSort.sort(arr);

        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
    }
}
