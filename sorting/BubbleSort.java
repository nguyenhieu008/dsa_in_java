package sorting;

import util.Utils;

public class BubbleSort implements Sorting {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j - 1, j);
                }
            }
        }
        Utils.printSortedList(arr);
    }
}
