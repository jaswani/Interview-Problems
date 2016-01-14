package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by jai around 10/5/15.
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        if(k < 2) return nums;
        int size = nums.length - k + 1;
        if(size <= 0) size = 1;
        int[] ret = new int[size];
        int i=0;
        for(; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ret[0] = nums[dq.peekFirst()];
        int j = 0;
        while(i < nums.length) {
            if (j == dq.peekFirst()) {
                dq.removeFirst();
            }
            j++;
            if(j == size) return ret;
            if(dq.isEmpty()) {
//                if(nums[i] >= nums[j]) dq.addFirst(i);
//                else dq.addFirst(j);
                System.out.println("Should not be hit");
            } else {
                if(nums[i] >= nums[dq.peekFirst()]) dq.addFirst(i);
                while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            ret[j] = nums[dq.peekFirst()];
            i++;
        }
        return ret;
    }
}
