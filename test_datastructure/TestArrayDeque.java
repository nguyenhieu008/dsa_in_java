package test_datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestArrayDeque {
    public static void test() {

        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(2);
        d.add(3);
        d.addLast(4);

        d.offer(5);
        d.offer(6);

        System.out.println(d);
        System.out.println("poll: " + d.poll());
        System.out.println("pop: " + d.pop());

    }
}
