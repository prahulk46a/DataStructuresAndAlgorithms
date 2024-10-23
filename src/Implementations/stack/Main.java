package Implementations.stack;

public class Main {

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());


    }
}
