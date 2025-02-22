package generation_methods;

import util.Utils;

public class GenerationMethods {
    public static void generateBinaryStrings(int n) {
        int[] arr = new int[n];

        int i = n;
        while (i != -1) {
            Utils.printIntString(arr);
            i = n - 1;
            while (i >= 0 && arr[i] == 1) {
                i--;
            }

            if (i >= 0) {
                arr[i] = 1;
                for (int j = i + 1; j < n; j++) arr[j] = 0;
            }
        }
    }

    public static void generateSubsets(int n, int k) {
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = i + 1;
        }

        int i = n;
        while (i != 0) {
            Utils.printSubset(arr);

            i = k;
            while (i > 0 && arr[i - 1] == n - k + i) {
                i--;
            }

            if (i > 0) {
                arr[i - 1]++;
                for (int j = i; j < k; j++) arr[j] = arr[j - 1] + 1;
            }
        }
    }
}
