package leetcode.LinkedList;

public class CycleQuestions {
    //    LL CONTAINS CYCLE OR NOT?
//      https://leetcode.com/problems/linked-list-cycle/
//    ASKED IN AMAZON AND MICROSOFT
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    //    Length of Cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);

                return length;
            }
            ;
        }

        return 0;
    }

//    Find the postion of the Start Node wheere the cycle Starts
//    https://leetcode.com/problems/linked-list-cycle-ii/

    public ListNode detectCycle(ListNode head) {
        int length = lengthCycle(head);
        if (length == 0) return null;

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < length; i++) {
            second = second.next;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

//    Google Question
//    Happy Number
//    https://leetcode.com/problems/happy-number/

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squareOfDigits(slow);   //Move Slow Pointer 1 by 1
            fast = squareOfDigits(squareOfDigits(fast));   //Move Fast Pointer 2 by 2
        } while (slow != fast);   // if Cycle is present it will exit and if it is not both slow & fast will be 1


        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int squareOfDigits(int num) {
        int square = 0;
        while (num > 0) {
            int rem = num % 10;
            square += rem * rem;
            num /= 10;
        }
        return square;
    }


    //    Middle NODE of a LL
    //    https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
