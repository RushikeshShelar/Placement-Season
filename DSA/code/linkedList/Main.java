package linkedList;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(4);
//        list.insertLast(4);
//        list.insertLast(4);
//        list.display();
//
//        list.duplicates();
//        list.display();


//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//
//        System.out.println(list.deleteAt(0));
//        list.display();
//        System.out.println(list.find(10));


//        DoublyLinkedList list = new DoublyLinkedList();
//        list.insertFirst(3);
//        list.insertFirst(5);
//        list.insertFirst(7);
//        list.insertFirst(8);
//
//        list.insertLast(12);
//        list.insertLast(20);
//        list.insertLast(99);
//
//
//        list.insertAfter(3,65);
//
//
////        list.display();
////        list.dispayReverse();
//        list.displayBoth();


//        CLL

//        CircularLinkedList list = new CircularLinkedList();
//
//        list.insert(3);
//        list.insert(5);
//        list.insert(7);
//        list.insert(8);
//
//        list.insert(12);
//        list.insert(20);
//        list.insert(99);
//
//
//        list.display();
//        list.delete(12);
//        list.display();
//
//        list.delete(3);
//        list.display();
//
//        list.delete(2);
//
//        list.display();



//  Merge two LL
//        SinglyLinkedList first = new SinglyLinkedList();
//        SinglyLinkedList second = new SinglyLinkedList();
//
//        first.insertLast(1);
//        first.insertLast(5);
//        first.insertLast(7);
//
//        second.insertLast(1);
//        second.insertLast(3);
//        second.insertLast(4);
//        second.insertLast(9);
//
//        SinglyLinkedList ans = SinglyLinkedList.merge(first,second);
//        ans.display();


//        Bubble sort LL

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(4);
        list.insertLast(3);
        list.insertLast(5);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(5);
        list.insertLast(7);
        list.insertLast(1);
        list.insertLast(25);
        list.insertLast(23);
        list.display();

        list.reverseInPlace();

        list.display();
    }
}
