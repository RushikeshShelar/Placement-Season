package linkedList;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
//    Insertions

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;

        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

    //    Deletion
    public void delete(int value) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (temp.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = temp.next;

            if (n.value == value) {
                temp.next = n.next;
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Node with Value " + value + " does not exist");
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
