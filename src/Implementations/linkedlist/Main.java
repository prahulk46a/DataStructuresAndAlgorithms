package Implementations.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedListImpl list=new LinkedListImpl();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertLast(50);

        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();

    }
}
