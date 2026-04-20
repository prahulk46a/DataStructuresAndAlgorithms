package collections;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addFirst(10);
        list.addLast(20);
        System.out.println(list);
        list.peek();
        list.poll();
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
