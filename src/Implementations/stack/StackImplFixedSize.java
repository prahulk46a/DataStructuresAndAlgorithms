package Implementations.stack;

import java.util.Arrays;

public class StackImplFixedSize {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    int top() {
        return arr[top];
    }
    int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        return "StackImplFixedSize{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", top=" + top +
                '}';
    }
}
