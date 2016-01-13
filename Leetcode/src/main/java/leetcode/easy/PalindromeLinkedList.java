package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {
    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode iter = head;
        while (iter != null) {
            length++;
            iter = iter.next;
        }

        if (length == 0 || length == 1) {
            return true;
        }

        int move = 0;
        move = length / 2;
        ListNode iter2 = head;
        while (move > 1) {
            iter2 = iter2.next;
            move--;
        }
        iter = iter2.next;
        iter2.next = null;
        ListNode end = iter2;
        ListNode start = iter;
        if (length % 2 != 0) {
            iter = iter.next;
        }
        iter2 = reverseList(head);
        while (iter != null || iter2 != null) {
            if (iter.val != iter2.val) {
                return false;
            }
            iter = iter.next;
            iter2 = iter2.next;
        }
        if (iter != null || iter2 != null) {
            return false;
        }
        return true;
    }

    ListNode reverseList(ListNode head) {
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
