package test_datastructure;

import dynamic_programming.BagProblem;
import dynamic_programming.BagProblem.Bag;
import util.Utils;

import java.util.Arrays;

public class TestArray {
//    public static void test() {
//        int[] a = {1, 2, 3, 4};
//        a = new int[]{5, 6, 7, 8, 9};
//
//        int[] b = new int[3];
//        System.arraycopy(a, 1, b,  0, 3);
//
//        System.out.print("a before: ");
//        Utils.printList(a);
//        System.out.print("b before: ");
//        Utils.printList(b);
//
//        System.out.println("============================");
//
//        b[0] = 10;
//        b[2] = 20;
//
//        System.out.print("a after: ");
//        Utils.printList(a);
//        System.out.print("b after: ");
//        Utils.printList(b);
//
//        System.out.println("is same array: " + (a == b));
//
//    }

//    public static void test() {
//        BagProblem.Bag[] bags = {
//                new Bag(3, 3),
//                new Bag(4, 4),
//                new Bag(5, 4),
//                new Bag(9, 10),
//                new Bag(4, 4)
//        };
//        Bag[] copyOfBags = bags.clone();
//
//        System.out.println("Bags:");
//        for (int i = 0; i < bags.length; i++) {
//            System.out.print(bags[i] + ", ");
//        }
//        System.out.println();
//        System.out.println("=========================");
//
//        copyOfBags[4].setWeight(100);
//        copyOfBags[0].setWeight(99);
//
//        System.out.println("Bags after:");
//        for (int i = 0; i < bags.length; i++) {
//            System.out.print(bags[i] + ", ");
//        }
//        System.out.println();
//
//        System.out.println("Copies of bags:");
//        for (int i = 0; i < copyOfBags.length; i++) {
//            System.out.print(copyOfBags[i] + ", ");
//        }
//        System.out.println();
//
//        System.out.println("is same array: " + (bags == copyOfBags));
//
////        BagProblem.bag(bags, 11);
//    }

    public static void test() {
        Integer[] a = {9, 5, 10, 3, 4, 15, 2};

        Arrays.sort(a, (x, y) -> y - x);

        for (Integer v: a) {
            System.out.print(v + ", ");
        }
        System.out.println();
    }
}
