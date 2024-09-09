package linkedList;

//DLL using Tail pointer
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.size = 0;
    }

//    Inserting Elements in the Double Linked List

    public void insertFirst(int value) {

        Node node = new Node(value);

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        if (tail == null) {
            tail = head;
        }

        head = node;
        size++;
    }



//    Insert last Without using Tail
    public void insertLast(int value){

        Node node = new Node(value);

        node.next = node;

        if(head ==  null){
            node.prev = null;
            head = node;
            return;
        }
        Node temp = head;


        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
        node.next = null;

    }


    public void insertAfter(int afterVal,  int value){
        Node prevNode = find(afterVal);

        if(prevNode == null){
            System.out.println("Node does not Exist");
            return;
        }

        Node node = new Node(value);

        node.next = prevNode.next;
        node.prev = prevNode;
        prevNode.next = node;

        if(node.next != null){
            node.next.prev = node;
        }


    }

//    Get reference
    public Node find(int val){
        Node temp = head;

        while (temp != null){
            if(temp.value == val){
                return temp;
            }
            temp = temp.next;

        }
        return null;
    }

    //    Print the DLL
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

//    Print the Reverse DLL
    public void dispayReverse(){
        if (tail == null) {
            System.out.println("NULL");
            return;
        }

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }


//    Print both forward and reverse without using Tail
    public void displayBoth(){
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        Node temp = head;
        Node last = null;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("Reverse Printing: ");

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }


    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
