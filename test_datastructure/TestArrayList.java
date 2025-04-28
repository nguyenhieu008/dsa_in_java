package test_datastructure;

import java.util.ArrayList;
import java.util.HashSet;

public class TestArrayList {
    public static void test() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1, 2);
        a.addLast(3);
        a.addFirst(5);
        a.remove(2);
        a.removeFirst();
        System.out.println("array list = " + a);
        System.out.println("first = " + a.getFirst());
        System.out.println("get at 1 = " + a.get(1));
        System.out.println("last = " + a.getLast());
        a.set(1, 9);
        a.add(0, 5);
        a.removeLast();

        HashSet<Integer> b = new HashSet<>();
        b.add(1);
        b.add(2);

        a.addAll(b);

        System.out.println("array list = " + a);

        a.clear();
        a.add(null);
        System.out.println("is empty with null: " + a.isEmpty());

        a.add(2);
        a.addFirst(1);
        a.addLast(3);
        a.add(2);
        a.add(null);

        System.out.println("array list = " + a);
        ArrayList<Integer> d = new ArrayList<>(a.subList(1, 3));
        System.out.println("sublist = " + d);
        System.out.println("is empty = " + a.isEmpty());
        System.out.println("array size = " + a.size());
        System.out.println("first index of 2 = " + a.indexOf(2));
        System.out.println("last index of 2 = " + a.lastIndexOf(2));
        System.out.println("contains = " + a.contains(5));

    }
}
