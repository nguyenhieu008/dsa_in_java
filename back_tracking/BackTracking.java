package back_tracking;

import util.Utils;

import java.util.Arrays;

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

    static class Route {
        int[] route;
        int cost;
        int length;

        Route(int[] r, int c, int l) {
            route = r;
            cost = c;
            length = l;
        }

        Route append(int next, int cost) {
            int newLength = this.length + 1;
            int[] newPath = Arrays.copyOf(this.route, newLength);
            newPath[newLength - 1] = next;
            int newCost = this.cost + cost;

            return new Route(newPath, newCost, newLength);
        }

        public String toString() {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < length; i++) {
                res.append((route[i] + 1) + "->");
            }
            res.append("\nCost: " + cost);
            return res.toString();
        }
    }

    public static void salesmen(int n, int[][] c) {
        boolean[] reached = new boolean[n];
        int[] r = {0};
        Route route = new Route(r, 0, 1);
        reached[0] = true;

        Route bestRoute = new Route(r, (int)Math.pow(10, 4), 1);

        Route result = salesmenBacktrack(c, n, reached, route, bestRoute);
        result.cost += c[result.route[result.length - 1]][0];

        System.out.println(result);

    }



    private static Route salesmenBacktrack (int[][] c, int n, boolean[] reached, Route route, Route bestRoute) {
        int prevCity = route.route[route.length - 1];
        if (route.length == n) {
//            System.out.println("Candidate: " + route);
//            System.out.println("Cur best route: " + bestRoute);
            if (route.cost + c[prevCity][0] < bestRoute.cost) {
                Route newRoute = route.append( 0, c[prevCity][0]);
//                System.out.println("new best route: " + newRoute);
                return newRoute;
            }
        }

//        System.out.println("trying route: " + route);

        if (route.cost >= bestRoute.cost) return bestRoute;

        for (int i = 1; i < n; i++) {
            if (!reached[i] && c[prevCity][i] != -1) {
                reached[i] = true;

                Route newRoute = route.append(i, c[prevCity][i]);
                bestRoute = salesmenBacktrack(c, n, reached, newRoute, bestRoute);
                reached[i] = false;
            }
        }
        return bestRoute;
    }


}
