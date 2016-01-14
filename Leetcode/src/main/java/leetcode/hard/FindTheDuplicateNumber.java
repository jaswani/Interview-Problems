package leetcode.hard;

/**
 * Created by jai around 9/28/15.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return -1;
        int andval = 1, ans = 0;
        for(int j = 0; j < 32; j++ ) {
            int actualCount = 0, exptectedCount = 0;
            for(int i = 0; i < nums.length; i++ ) {
                if (i+1 != nums.length && (i+1 & andval) == andval) {
                    exptectedCount++;
                }
                if ((nums[i] & andval) == andval) {
                    actualCount++;
                }
            }
            if(actualCount > exptectedCount) {
                ans |= andval;
            }
            andval <<= 1;
        }
        return ans;
    }
}
