package leetcode.medium;

/**
 * Created by jai around 9/28/15.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
 * complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        long sum = 0;
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long totalSum = ((long)nums.length)*(nums.length+1) / 2;
        return (int)(totalSum - sum);
    }
}
