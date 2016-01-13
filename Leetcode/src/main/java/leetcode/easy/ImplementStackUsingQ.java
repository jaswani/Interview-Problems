package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by jai around 9/28/15.
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and
 * is empty operations are valid.
 *
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or
 * deque (double-ended queue), as long as you use only standard operations of a queue.
 *
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty
 * stack).
 */
public class ImplementStackUsingQ {
    Queue<Integer> pushQ = new ArrayDeque<Integer>();
    Queue<Integer> popQ = new ArrayDeque<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        pushQ.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!empty()) {
            getLast(true);
        }
        return;
    }

    // Get the top element.
    public int top() {
        if(!empty()) {
            return getLast(false);
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return pushQ.isEmpty() && popQ.isEmpty();
    }

    private Integer getLast(boolean remove) {
        if (empty()) {
            return null;
        }
        Integer last = null;
        while(pushQ.size() > 1) {
            popQ.add(pushQ.remove());
        }
        last = pushQ.remove();
        if (!remove) {
            popQ.add(last);
        }
        swapQ();
        return last;
    }

    private void swapQ() {
        Queue<Integer> tempQ = pushQ;
        pushQ = popQ;
        popQ = tempQ;
    }
}
