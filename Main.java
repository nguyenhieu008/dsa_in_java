import back_tracking.BackTracking;
import sorting.*;
import util.Utils;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 34, 11, 8, 93, 5, 4, 45, 62, 33, 4};
        System.out.print("Before sort: ");
        Utils.printList(arr);
        Sorting sortAlgo = new QuickSort();
        sortAlgo.sort(arr);
    }
}
