package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 */
public class RemoveNthNodeFromEndOfList {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < n && curr != null; i++) curr = curr.next;
        prev = head;
        ListNode pprev = null;
        while (curr != null) {
            pprev = prev;
            prev = prev.next;
            curr = curr.next;
        }
        if (prev == head) {
            //delete the first node
            head = head.next;
        } else {
            pprev.next = prev.next;
        }
        return head;
    }
}
