package Implementations.stack;

public class Main {

    public static void main(String[] args) {
        StackImplVariableSize stack = new StackImplVariableSize();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }
}
