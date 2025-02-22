package generation_methods;

import util.Utils;

public class BackTracking {
    public static void generateBinaryStrings(int n) {
        int[] arr = new int[n];

        binaryBacktrack(arr, n, 0);
    }

    private static void binaryBacktrack(int[] arr, int n, int i) {
        if (i == n) {
            Utils.printIntString(arr);
            return;
        }
        arr[i] = 0;
        binaryBacktrack(arr, n, i + 1);

        arr[i] = 1;
        binaryBacktrack(arr, n, i + 1);
    }

    public static void generateSubsets(int n, int k) {
        int[] arr = new int[k];

        subsetBacktrack(arr, n, k, 0, 1);
    }

    private static void subsetBacktrack(int[] arr, int n, int k, int i, int start) {
        if (i == k) {
            Utils.printSubset(arr);
            return;
        }

        for (int j = start; j <= n - k + i + 1; j++) {
            arr[i] = j;
            subsetBacktrack(arr, n, k, i + 1, arr[i] + 1);
        }
    }

    public static void generateArrangements(int n, int k) {
        int[] arr = new int[k];
        boolean[] acquired = new boolean[n];

        arrangementBacktrack(arr, n, k, 0, acquired);
    }

    private static void arrangementBacktrack(int[] arr, int n, int k, int cur, boolean[] acquired) {
        if (cur == k) {
            Utils.printSubset(arr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!acquired[i]) {
                acquired[i] = true;
                arr[cur] = i;
                arrangementBacktrack(arr, n, k, cur + 1, acquired);
                acquired[i] = false;
            }
        }
    }

    public static void generateQueens(int n) {
        int[] queens = new int[n];
        boolean[] y, c1, c2;
        y = new boolean[n];
        c1 = new boolean[2 * n];
        c2 = new boolean[2 * n];

        queenBacktrack(n, queens, 0, y, c1, c2);
    }

    private static void queenBacktrack(int n, int[] queens, int row, boolean[] y, boolean[] c1, boolean[] c2) {
        if (row == n) {
            Utils.printQueens(queens);
            return;
        }

        for (int i = 0; i < n; i++) {
            int column = i;
            int cross1 = i + row;
            int cross2 = i - row + n;
            if (!y[column] && !c1[cross1] && !c2[cross2]) {
                y[column] = c1[cross1] = c2[cross2] = true;
                queens[row] = column;
                queenBacktrack(n, queens, row + 1, y, c1, c2);
                y[column] = c1[cross1] = c2[cross2] = false;
            }
        }
    }
}
