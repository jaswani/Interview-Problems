package leetcode.easy;

/**
 * Created by jai around 9/21/15.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = -1, end = -1;
        for(int i = 0; i < nums.length; i++) {
            //check
            if (nums[i] == 0) {
                if (start == -1) {
                    start = end = i;
                } else {
                    end = i;
                }
            } else {
                if(start == -1) {
                    continue;
                } else {
                    nums[start] = nums[i];
                    nums[i] = 0;
                    if(start == end) {
                        start = end = i;
                    } else {
                        start += 1;
                        end = i;
                    }
                }
            }
        }
    }
}
