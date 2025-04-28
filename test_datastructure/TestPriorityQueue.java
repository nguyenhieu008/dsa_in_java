package test_datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {

    static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer a, Integer b) {
            return b - a;
        }
    }
    public static void test() {
        PriorityQueue<Integer> q  = new PriorityQueue<>(new MaxComparator());

        q.add(5);
        q.add(1);
        q.add(9);
        q.add(6);
        q.add(1);

        System.out.println("peek: " + q.peek());
        System.out.println("whole heap: " + q);

        q.add(0);
        System.out.println("peek: " + q.peek());
        System.out.println("whole heap: " + q);

        System.out.println("poll: " + q.poll());
        System.out.println("whole heap: " + q);

        System.out.println("remove: " + q.remove());
        System.out.println("remove: " + q.remove());
        System.out.println("remove: " + q.remove());
    }
}
