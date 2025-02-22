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
}
