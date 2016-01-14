package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (prev != null) {
                if (prev.val == curr.val) {
                    prev.next = curr.next;
                    curr = curr.next;
                    continue;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
