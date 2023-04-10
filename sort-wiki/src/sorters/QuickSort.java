package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static List<int[]> sort(int[] arr) {
        List<int[]> list = new ArrayList<int[]>();
        list.add(Arrays.copyOf(arr, arr.length));
        partition(arr, 0, arr.length, list);
        return list;
    }

    private static void partition(int[] arr, int start, int end, List<int[]> list) {
        if (end - start <= 1) {
            return;
        }

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
                    list.add(Arrays.copyOf(arr, arr.length));
                }
                i++;
                if (i == pivotPos)
                    i++;
            }
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
