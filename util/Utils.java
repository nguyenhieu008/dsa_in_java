package util;

public class Utils {
    public static void printIntString(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void printSubset(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("}");
    }

    public static void printQueens(int[] queens) {
        for (int i = 0; i < queens.length; i++) {
            System.out.print("(" + i + ", " + queens[i] + "); ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printSortedList(int[] arr) {
        System.out.print("After sort: ");
        printList(arr);
    }

    public static void printList(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void printListSegment(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print2dArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
