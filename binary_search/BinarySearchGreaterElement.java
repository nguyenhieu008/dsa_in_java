package binary_search;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;

class BinarySearchGreaterElement {
//    public static void main(String[] args) {
//        int[] a = { 1, 2, 3, 5, 8, 12 };
//        System.out.println("Greater Index: " + binaryGreater(a, 4));
//        System.out.println("Greater Index: " + binaryGreater(a, 5));
//        System.out.println("Greater Index: " + binaryGreater(a, 11));
//        System.out.println("Greater Index: " + binaryGreater(a, 12));
//        System.out.println("Greater Index: " + binaryGreater(a, 13));
//    }

    public int binaryGreater(int[] a, int target) {
        int l = 0, r = a.length;

        while (r - l > 0) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}