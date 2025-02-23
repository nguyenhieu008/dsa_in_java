package sorting;

import util.Utils;

public class SelectionSort implements Sorting {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            Utils.swap(arr, i, minIdx);
        }

        Utils.printSortedList(arr);
    }
}
