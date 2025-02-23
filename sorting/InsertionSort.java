package sorting;

import util.Utils;

public class InsertionSort implements Sorting {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n - 1; i++) {
            int temp = arr[i];

            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        Utils.printSortedList(arr);
    }
}
