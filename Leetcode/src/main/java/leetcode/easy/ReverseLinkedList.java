package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode iter = head;
        ListNode prev = null;
        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = prev;
            prev = iter;
            iter = temp;
        }
        return prev;
    }
}
