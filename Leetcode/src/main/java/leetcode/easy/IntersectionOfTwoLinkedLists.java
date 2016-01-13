package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                     c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0, diff = 0;
        ListNode iter = headA;
        while (iter != null) {
            lengthA++;
            iter = iter.next;
        }
        iter = headB;
        while (iter != null) {
            lengthB++;
            iter = iter.next;
        }
        ListNode bigList, smallList;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            bigList = headA;
            smallList = headB;
        } else {
            diff = lengthB - lengthA;
            bigList = headB;
            smallList = headA;
        }
        while (diff > 0) {
            bigList = bigList.next;
            diff--;
        }
        while (bigList != null || smallList != null) {
            if (bigList == smallList) {
                return bigList;
            }
            bigList = bigList.next;
            smallList = smallList.next;
        }
        return null;
    }
}
