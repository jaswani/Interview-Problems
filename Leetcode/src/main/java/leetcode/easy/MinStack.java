package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    List<Integer> stack = new ArrayList<Integer>();
    List<Integer> index = new ArrayList<Integer>();
    int minValue = Integer.MAX_VALUE;
    public void push(int x) {
        if(stack.isEmpty()) {
            minValue = x;
            index.add(0);
        }
        stack.add(x);
        if(x < minValue) {
            minValue = x;
            index.add(stack.size()-1);
        }

    }

    public void pop() {
        if(stack.isEmpty()) return;
        if ((stack.size()-1) == index.get(index.size()-1)) {
            index.remove(index.size()-1);
            if(!index.isEmpty()) {
                minValue = stack.get(index.get(index.size()-1));
            }
        }
        stack.remove(stack.size()-1);
        // if(stack.isEmpty()) {
        //     index.clear(); //not needed
        //     // minValue = Integer.MAX_VALUE;
        // }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return stack.get(index.get(index.size()-1));
    }
}
