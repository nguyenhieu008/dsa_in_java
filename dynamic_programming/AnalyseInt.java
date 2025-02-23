package dynamic_programming;

import util.Utils;

public class AnalyseInt {
    public static void analyse(int n) {
        int[][] f = new int[n + 1][n + 1];

        f[0][0] = 1;

        for (int m = 1; m <= n; m++) {
            for (int v = 0; v <= n; v++) {
                if (v < m) {
                    f[m][v] = f[m-1][v];
                } else {
                    f[m][v] = f[m-1][v] + f[m][v-m];
                }
            }
        }

        System.out.println("DP table: ");
        Utils.print2dArray(f);

        System.out.format("Ways to analyse an integer %d: %d", n, f[n][n]);
    }
}
