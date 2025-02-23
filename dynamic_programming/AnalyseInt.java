package dynamic_programming;

import util.Utils;

public class AnalyseInt {
    public void analyse(int n) {
        analyseRecursive(n);
    }

    private int[][] dp = new int[10][10];

    public AnalyseInt() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = -1;
            }
        }

        // Must go first because dp[0][0] = 1;
        for (int j = 0; j < 10; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }
    }

    private void analyseRecursive(int n) {
        System.out.println("DP table before: ");
        Utils.print2dArray(dp, n + 1);

        int result = analyse(n, n);

        System.out.println("DP table after: ");
        Utils.print2dArray(dp, n + 1);

        System.out.format("Ways to analyse an integer %d: %d", n, result);

    }

    private int analyse(int m, int v) {
        if (dp[m][v] != -1) {
            return dp[m][v];
        }

        if (m > v) {
            dp[m][v] = analyse(m-1, v);
        } else {
            dp[m][v] = analyse(m-1, v) + analyse(m, v-m);
        }
        return dp[m][v];
    }

    private void analyseDp(int n) {
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
