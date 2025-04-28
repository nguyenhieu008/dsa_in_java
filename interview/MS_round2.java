import java.util.*;

// count[]
// longest[]
// a[]

// binary string: "00110011"
// substring:
//   - so 0 va 1 bang nhau
//   - cac so 0 va cac so 1 lien nhau
// output 6;
// "01", "0011", "10", "1100", "01", "0011"

// for i, if (a[i] != a[i-1]) => count[i] = count[i-1] + 1; longest[i] = 2
//          else if (a[i] == a[i-i] && a[i] != a[i-1-longest[i-1]]) => count[i] = count[i-1] + 1; longest[i] = longest[i-1] + 2;
//          else count[i] = count[i-1]; longest[i] = 0;

//

class Main1 {
    // sum of continous
    static int sum(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] input = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        int n = input.length;

        HashMap<Integer, Integer> count = new HashMap<>();
        // Create all subsets
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = sum(input, i, j);
                if (count.containsKey(v)) {
                    count.put(v, count.get(v) + 1);
                } else {
                    count.put(v, 1);
                }
            }
        }

        // find result
        boolean res = false;
        for (int v : count.values()) {
            if (v >= k) {
                res = true;
                break;
            }
        }

        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}