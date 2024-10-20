package Implementations.stack;

import java.util.Arrays;

public class StackImplVariableSize {
    protected int[] stack;
    private final int DEFAULT_SIZE=10;
    int top=-1;

    public StackImplVariableSize(){
        stack = new int[DEFAULT_SIZE];
    }

    public StackImplVariableSize(int size){
        stack = new int[size];
    }
    public boolean isEmpty(){
        return stack.length==0;
    }
    public int size(){
        return stack.length;
    }

    public boolean isFull(){
        if(top==stack.length-1){
            return true;
        }
        return false;
    }
    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is full!!");
            return false;
        }
        top++;
        stack[top] = item;
        return true;
    }

    public int peek()  {
        if (isEmpty()) {
            System.out.println("Stack is empty so no top!!");
        }
        return stack[top];
    }
    public int pop()  {
        if (isEmpty()) {
            System.out.println("Sttack is empty!!");
        }
        return stack[top--];
    }

    @Override
    public String toString() {
        return "StackImplVariableSize{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
