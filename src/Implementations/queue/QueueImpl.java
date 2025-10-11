package Implementations.queue;

public class QueueImpl {
    private int[] arr;
    private int front, rear, size, capacity;

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }

    public boolean isFull() { return size == capacity; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return arr[front];
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        System.out.println("Dequeued: " + q.dequeue());
        q.printQueue();
    }
}
