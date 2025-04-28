package interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'prison' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER_ARRAY h
     *  4. INTEGER_ARRAY v
     */

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        boolean[] removedV = new boolean[m+1];
        boolean[] removedH = new boolean[n+1];

        for (int hor : h) {
            removedH[hor] = true;
        }
        for (int ver : v) {
            removedV[ver] = true;
        }

        int[] dpV = new int[m+2];
        int[] dpH = new int[n+2];
        int maxV = 0;
        int maxH = 0;
        for (int col = 1; col < m + 2; col++) {
            if (removedV[col - 1] == true) {
                dpV[col] = dpV[col-1] + 1;
            } else {
                dpV[col] = 1;
            }
            maxV = Math.max(dpV[col], maxV);
        }
        for (int row = 1; row < n + 2; row++) {
            if (removedH[row - 1] == true) {
                dpH[row] = dpH[row-1] + 1;
            } else {
                dpH[row] = 1;
            }
            maxH = Math.max(dpH[row], maxH);
        }


        return (long)maxV * maxH;

    }

}


public class WQ_round1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int hCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = IntStream.range(0, hCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int vCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> v = IntStream.range(0, vCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.prison(n, m, h, v);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}