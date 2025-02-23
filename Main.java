import back_tracking.BackTracking;
import dynamic_programming.AnalyseInt;
import dynamic_programming.BagProblem;
import dynamic_programming.BagProblem.Bag;
import sorting.*;
import util.Utils;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {2, 34, 11, 8, 93, 5, 4, 45, 62, 33, 4};
//        System.out.print("Before sort: ");
//        Utils.printList(arr);
//        Sorting sortAlgo = new HeapSort();
//        sortAlgo.sort(arr);

        Bag[] bags = {
                new Bag(3, 3),
                new Bag(4, 4),
                new Bag(5, 4),
                new Bag(9, 10),
                new Bag(4, 4)
        };

        BagProblem.bag(bags, 11);

//        a.analyse(6);
    }
}
