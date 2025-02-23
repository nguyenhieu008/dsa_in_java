package sorting;

import util.Utils;

public class QuickSort implements Sorting {
    public void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
        Utils.printSortedList(arr);
    }

    private void sort(int[] arr, int start, int end) {
        Utils.printListSegment(arr, start, end);
        if (start >= end) return;
        int pivot = arr[start];
        int l = start, r = end;

        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;

            if (l <= r) {
                Utils.swap(arr, l, r);
                l++;
                r--;
            }
        }

        sort(arr, start, r);
        sort(arr, l, end);
    }

}
