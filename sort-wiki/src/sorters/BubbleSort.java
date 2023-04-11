package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	public static List<int[]> sort(int[] arr) {
		List<int[]> list = new ArrayList<int[]>();
		list.add(Arrays.copyOf(arr, arr.length));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1])
					swap(arr, j, j+1);
				list.add(Arrays.copyOf(arr, arr.length));
			}
		}
		return list;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
