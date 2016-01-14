package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int [] max = new int[nums.length];
        int[] last = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int iminus2 = amount(i-2,max);
            int iminus1 = amount(i-1,max);
            if(nums[i] + iminus2 > iminus1) {
                max[i] = nums[i] + iminus2;
                last[i] = i;
            } else {
                max[i] = iminus1;
                if (i > 0) last[i] = last[i-1];
            }
        }
        return max[nums.length-1];
    }

    private int amount(int i, int[] max) {
        if(i < 0) return 0;
        return max[i];
    }
}
