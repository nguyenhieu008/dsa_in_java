package test_datastructure;

import java.util.Stack;

public class TestStack {
    public static void test() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.add(2);
        s.addFirst(3);
        s.addLast(4);
        System.out.println("search index of 1: " + s.search(5));
        System.out.println("first index of 1: " + s.indexOf(5));
        System.out.println("size = " + s.size());
        System.out.println("peek = " + s.peek());
        System.out.println("get index of 1 = " + s.get(0));
        s.clear();

        while (!s.isEmpty()) {
            System.out.println("elem = " + s.pop());
        }
    }
}
