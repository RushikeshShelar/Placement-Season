package leetcode.LinkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class InterviewQuestions {


//    Reverse a particular Part of linked list
//    GOOGLE, MICROSOFT, FACEBOOK https://leetcode.com/problems/reverse-linked-list-ii/
//    Reverse Between left and Right

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // Skip the first left - 1 nodes
        ListNode curr = head;
        ListNode prev = null;

        for (int i = 0; curr != null && i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode last = prev;
        ListNode newEnd = curr;
        ListNode next = curr.next;
        // Reverse between left and Right
        for (int i = 0; curr != null && i < right - left + 1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }

    //    Palindrome Linked List
//    GOOGLE, AMAZON, FACEBOOK, LINKEDIN
//    https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reReverseHead = headSecond;  //For Re reversing the 2nd Half of the List

//            compare both halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(reReverseHead);

        return head == null || headSecond == null;
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }


    //    Reorder List
//    GOOGLE
//    https://leetcode.com/problems/reorder-list/description/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNodeWithoutSplitingList(head);

        ListNode headFirst = head;
        ListNode headSecond = reverseList(mid);

//        Rearrange
        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

//        Next of Tail points to null
        if (headFirst != null) {
            headFirst.next = null;
        }
    }

    public ListNode middleNodeWithoutSplitingList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //    LEETCODE HARD
//    Reverse Nodes in K Group
//    GOOGLE AMAZON FACEBOOK MICROSOFT
//    https://leetcode.com/problems/reverse-nodes-in-k-group/description/
//    NOT UNDERSTOOD CHECK AGAIN ONCE
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        int remainingLength = listLength(head);
        while (remainingLength >= k) {

            ListNode last = prev;
            ListNode newEnd = curr;

            ListNode next = curr.next;

            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;

            if (curr == null) {
                break;
            }

            prev = newEnd;
            remainingLength -= k;
        }
        return head;
    }

    public int listLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length += 1;
            temp = temp.next;
        }
        return length;
    }

//    Revere Alternate K node in group
//    https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/

    public ListNode reverseAltKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        int remainingLength = listLength(head);
        while (remainingLength >= k) {

            ListNode last = prev;
            ListNode newEnd = curr;

            ListNode next = curr.next;

            for (int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;

            if (curr == null) {
                break;
            }

            prev = newEnd;
            remainingLength -= k;

            for (int i = 0; curr != null && i < k; i++) {
                prev = curr;
                curr = curr.next;

            }
        }
        return head;
    }


    //    Rotate Linked List k times
//    FaceBook Twitter Google
//    https://leetcode.com/problems/rotate-list/submissions/1384417852/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }

        int length = listLength(head);

        ListNode tail = head;
        ListNode prev = null;
        for (int i = 0; i < (k % length); i++) {
            while (tail.next != null) {
                prev = tail;
                tail = tail.next;
            }
            tail.next = head;
            prev.next = null;
            head = tail;
        }
        return head;
    }

    //    Another approach to above problem
    public ListNode rotateRightNew(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;

        int rotations = k % length;
        int skip = length - rotations;

        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;


        return head;
    }
}
