package leetcode.medium;

/**
 * Created by jai around 10/19/15.
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
 * not get too much attention. This time, all houses at this place are arranged in a circle. That means the first
 * house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those
 * in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 *
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int iminus2 = 0, iminus1 = 0;
        int maxfwd = 0;
        int maxbwd = 0;
        if(nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] + iminus2 > iminus1) {
                int temp = iminus1;
                iminus1 = nums[i] + iminus2;
                iminus2 = temp;
            } else {
                iminus2 = iminus1;
            }
        }
        maxfwd = iminus1;
        iminus2 = 0;
        iminus1= 0;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] + iminus2 > iminus1) {
                int temp = iminus1;
                iminus1 = nums[i] + iminus2;
                iminus2 = temp;
            } else {
                iminus2 = iminus1;
            }
        }
        maxbwd = iminus1;

        return maxfwd > maxbwd ? maxfwd : maxbwd;
    }
}
