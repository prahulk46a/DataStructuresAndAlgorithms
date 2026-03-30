package collections;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60);
            System.out.println(stack);

            System.out.println(stack.pop());
            System.out.println(stack.peek());
            System.out.println(stack.size());
            System.out.println(stack.set(2, 100)); // Change element at index 2 to 100
            System.out.println("Element At  index 2:"+stack.get(2)); // Get element at index 2
            System.out.println(stack);
    }
}
