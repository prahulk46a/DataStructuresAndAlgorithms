package Implementations.stack;

import java.util.LinkedList;

public class StackUsingLL {
    Node top;
    StackUsingLL() {
        this.top = null;       //Initialize top null
    }
    boolean isEmpty() {
        return top == null;
    }
    public void push(int x) {
        Node newNode = new Node(x);
        if (top == null) {
            top = newNode;      //first made top as first node inserted
            return;
        }
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            top=null;
            return 0;
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        return top.data;
    }

    @Override
    public String toString() {
        return "StackUsingLL{" +
                "top=" + top +
                '}';
    }
}
