package test_datastructure;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
    static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }
    public static void test() {
        TreeSet<Integer> s = new TreeSet<>(new MaxComparator());

        s.add(1);
        s.add(3);
        s.add(5);
        s.add(7);

        System.out.println("whole tree: " + s);
        System.out.println("peek: " + s.first());
        System.out.println("ceiling: " + s.ceiling(4));
        System.out.println("floor: " + s.floor(4));
        System.out.println("contain: " + s.contains(4));
        System.out.println("head set: " + s.headSet(4));
        System.out.println("lower: " + s.lower(4));

        System.out.println("poll: " + s.pollFirst());
        System.out.println("subset: " + s.subSet(2, 6));
        System.out.println("tailset: " + s.tailSet(4));
        System.out.println("whole tree: " + s);
    }
}
