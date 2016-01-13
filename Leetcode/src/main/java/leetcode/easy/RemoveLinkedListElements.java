package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode iter = head;
        ListNode prev = null;
        while (iter != null) {
            if (iter.val == val) {
                prev.next = iter.next;
            } else {
                prev = iter;
            }
            iter = iter.next;
        }
        return head;
    }
}
