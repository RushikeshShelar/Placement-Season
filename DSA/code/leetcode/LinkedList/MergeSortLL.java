package leetcode.LinkedList;


import com.sun.deploy.util.LinkMouseListener;
import linkedList.SinglyLinkedList;

public class MergeSortLL {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);

        ListNode left = sortList(head); // First List that starts at Head. Its last Node.next = null due to middle node function;
        ListNode right = sortList(mid); // Second list that starts at Mid. Its last Node.next = null due to LL property last node points to null

        return mergeTwoLists(left, right); //Merge Two LinkedList

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode list = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list.next = list1;
                list1 = list1.next;
            } else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }

        while (list1 != null) {
            list.next = list1;
            list1 = list1.next;
            list = list.next;
        }

        while (list2 != null) {
            list.next = list2;
            list2 = list2.next;
            list = list.next;
        }

        return head.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevMid = null;

        while (fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevMid.next = null;   //Set the Next of previous to mid node as prev.next = null. So to Properly break the Chain and to form two separate linked list
        return slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }



}
