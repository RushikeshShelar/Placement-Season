package linkedList;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import leetcode.LinkedList.MergeSortLL;

public class SinglyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }


    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insertAt(int val, int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index Does not exist");
        }

        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        //        Using Another Constructor
        Node node = new Node(val, temp.next);
        temp.next = node;


        //        Using Rushi Logic
        //        Node node = new Node(val);
        //        node.next = temp.next;
        //        temp.next = node;

        size++;
    }


//    Insert using Recursion

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void display() {

        if (head == null) {
            System.out.println("NULL");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        // get the 2nd last node
        Node secondLast = get(size - 2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public int deleteAt(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index Does not exist");
        }

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size) {
            return deleteLast();
        }

        Node prevNode = get(index - 1);

        int val = prevNode.next.value;
        prevNode.next = prevNode.next.next;

        size--;
        return val;
    }

    //    Get reference of a node at index
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }


    //     Find the node with value
    public int find(int val) {
        Node temp = head;
        int index = -1;
        while (temp != null) {
            index++;
            if (temp.value == val) {

                return index;
            }
            temp = temp.next;
        }
        return -1;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //    Questiosns

    //    Leetcode 83: Remove Duplicates from LL
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

//  Leetcode 21: Merger two Sorted List;

    public static SinglyLinkedList merge(SinglyLinkedList first, SinglyLinkedList second) {
        SinglyLinkedList ans = new SinglyLinkedList();

        Node f = first.head;
        Node s = second.head;

        while (f != null && s != null) {
            if (f.value <= s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }


    //    Bullble Sort LinkedList

    // REFER row col concept in Patter Recursion video of Bubble Sort
    public void bubbleSort() {
        bubbleSort(size - 1, 0);

    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
//            Swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    second.next = first;
                    first.next = null;
                    tail = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }


    // Inplace Reverse of Linked List
    public void reverseInPlace() {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

}
