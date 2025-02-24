package dynamic_programming;

import util.Utils;

public class BagProblem {

    public static class Bag {
        int v;
        int w;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public String toString() {
            return String.format("(value: %d, weight: %d)", v, w);
        }

        public void setWeight(int w) {
            this.w = w;
        }
    }

    public static void bag(Bag[] bags, int m) {
        int n = bags.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            f[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Bag bag = getBag(bags, i);
                int bagValue = bag.v;
                int bagWeight = bag.w;

                int value = f[i - 1][j];

                if (j >= bagWeight) {
                    value = Math.max(value, bagValue + f[i - 1][j - bagWeight]);
                }


                f[i][j] = value;
            }
        }

        System.out.println("Bags dp table: ");
        Utils.print2dArray(f);

        System.out.println("Max possible value = " + f[n][m]);
    }

    private static Bag getBag(Bag[] bags, int i) {
        return bags[i - 1];
    }
}
