package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //Cheated ... had to left to right and right to left hint :(
        int[] o = new int[nums.length];
        o[0] = nums[0];
        int i = 1;
        for(; i < nums.length-1; i++) {
            o[i] = o[i-1]*nums[i];
        }

        o[i] = o[i-1];
        int j = nums.length-1;
        int val = 1;
        for(i = i-1; i >= 0; i--) {
            val *= nums[j--];
            if (i > 0) o[i] = o[i-1]*val;
            else o[i] = val;
        }
        return o;
    }
}
