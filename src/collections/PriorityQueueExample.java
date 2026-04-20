package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // By default Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5,(a, b) -> b - a); // Max-heap with size 5

        /*
        # Priority queue with initial capacity of 3
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);

        # Priority Queue with comparator
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a); // Max-heap

        # Priority Queue with capacity and comparator
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5,(a, b) -> b - a); // Max-heap with size 5

        #
         */
        pq.add(15);
        pq.offer(30);
        pq.offer(40);
        pq.offer(50);
        pq.offer(10);
        pq.offer(20);



//        while(!pq.isEmpty()){
//            printTree(pq);
//            System.out.println(pq.poll());
//        }

        // Iterator
        Iterator<Integer> value = pq.iterator();
        while(value.hasNext()){
            System.out.println(value.next());
        }
    }

    public static void printTree(PriorityQueue<Integer> pq) {
        List<Integer> heap = new ArrayList<>(pq);
        int n = heap.size();

        int height = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
        int maxNodes = (int) Math.pow(2, height) - 1;

        // Fill missing nodes with null for perfect shape
        List<Integer> fullTree = new ArrayList<>(heap);
        while (fullTree.size() < maxNodes) {
            fullTree.add(null);
        }

        int index = 0;

        for (int level = 0; level < height; level++) {
            int nodes = (int) Math.pow(2, level);
            int space = (int) Math.pow(2, height - level);

            // print node row
            printSpaces(space / 2);

            for (int i = 0; i < nodes; i++) {
                Integer val = fullTree.get(index++);

                if (val != null)
                    System.out.printf("%2d", val);
                else
                    System.out.print("  ");

                printSpaces(space);
            }
            System.out.println();

            // print branches
            if (level < height - 1) {
                printSpaces(space / 2);

                for (int i = 0; i < nodes; i++) {
                    Integer left = fullTree.get(2 * (index - nodes + i) + 1);
                    Integer right = fullTree.get(2 * (index - nodes + i) + 2);

                    System.out.print(left != null ? "/" : " ");
                    printSpaces(space - 2);
                    System.out.print(right != null ? "\\" : " ");
                    printSpaces(space);
                }
                System.out.println();
            }
        }
    }

    private static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }
}
