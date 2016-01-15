package leetcode.medium;

import java.util.Arrays;

/**
 * Created by jai around 10/5/15.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long closest = Long.MAX_VALUE;
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length-1;
            while(j<k) {
                long sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return (int)sum;
                } else if (sum > target) {
                    if(sum-target < closest) {
                        closest = sum-target;
                        ans = sum;
                    }
                    k--;
                } else {
                    if(target-sum < closest) {
                        closest = target-sum;
                        ans = sum;
                    }
                    j++;
                }
            }
        }
        return (int)ans;
    }
}
