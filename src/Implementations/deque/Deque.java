package Implementations.deque;

public class Deque <T>{
    private static class Node<T> {
        T data;
        Node<T> next, prev;
        Node(T data) { this.data = data; }
    }

    private Node<T> head, tail;
    private int size = 0;

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("Deque is empty");
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (tail == null) throw new RuntimeException("Deque is empty");
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return data;
    }

    public T peekFirst() { return (head == null) ? null : head.data; }
    public T peekLast()  { return (tail == null) ? null : tail.data; }
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addFirst(5);

        System.out.println("Deque: " + deque);
        System.out.println("Front: " + deque.peekFirst());
        System.out.println("Rear: " + deque.peekLast());
        deque.removeFirst();
        deque.removeLast();
        System.out.println("After removals: " + deque);
    }
}
