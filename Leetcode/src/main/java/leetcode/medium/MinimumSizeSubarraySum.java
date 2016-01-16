package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0;
        int min = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum - nums[low] >= s) {
                sum -= nums[low];
                low++;
            }
            if(sum >= s && (min == 0 || i-low+1 < min)) min = i-low+1;
        }
        return min;
    }
}
