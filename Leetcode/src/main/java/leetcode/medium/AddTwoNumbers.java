package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        int carry = 0;
        ListNode head = null, iter = null;
        while (l1 != null || l2 != null) {
            ListNode ans = iteration(carry, l1, l2);
            if (ans.val > 9) {
                carry = 1;
                ans.val = ans.val % 10;
            } else {
                carry = 0;
            }
            if (head == null) {
                iter = head = ans;
            } else {
                iter.next = ans;
                iter = ans;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 == null) {
                l1 = l2;
                l2 = null;
            }
        }
        if (carry > 0) iter.next = new ListNode(carry);
        return head;
    }

    private ListNode iteration(int carry, ListNode l1, ListNode l2) {
        int sum = l1.val + carry;
        if (l2 != null) sum += l2.val;
        return new ListNode(sum);
    }
}
