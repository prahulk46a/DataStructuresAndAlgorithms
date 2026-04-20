package collections;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // Add elements to the front and back
        deque.addFirst(10);  // add-> throws exception
        deque.addLast(20);
        deque.add(30);          // adds element to last
        deque.offerFirst(5); // offer-> doesn't throw exception
        deque.offerLast(25);

        System.out.println(deque);

        //Remove elements
        deque.remove(); // removes first element from dequeue exception throws
        deque.poll();   // removes first element from dequeue doesn't throw exception
        deque.pollLast();  // polls from last of dequeue
        System.out.println(deque);

        deque.peek(); // peek first element of dequeue
        System.out.println(deque);
        deque.push(15); // push element to front of dequeue (behaves like stack)
        System.out.printf("After push: %s\n", deque);
    }
}
