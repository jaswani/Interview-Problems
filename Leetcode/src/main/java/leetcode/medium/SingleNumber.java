package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x=0;
        for(int i=0; i <nums.length; i++) x^=nums[i];
        return x;
    }
}
