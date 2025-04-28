package test_datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedList {
    public static void test() {

        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(1, 4);
        System.out.println("elem 2: " + l.get(2));
        System.out.println("peek: " + l.peek());
        System.out.println("pop: " + l.pop());
        l.set(0, 1);

        l.push(5);


        ListIterator<Integer> it = l.listIterator();
        while (it.hasNext()) {
            Integer item = it.next();
            System.out.println("iterating: " + item);

            // it.remove(); // can modify list while iterating
        }
        while (it.hasPrevious()) {
            Integer item = it.previous();
            System.out.println("iterating backward: " + item);
            if (item == 1) {
                it.remove();
            }
        }



        System.out.println(l);

    }
}
