package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        int posprdct = 1;
        int negprdct = 1;
        boolean posprdctset = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                if (negprdct == 1) {
                    negprdct = posprdct*nums[i];
                    posprdct = 1;
                } else {
                    int temp = negprdct*nums[i];
                    negprdct = posprdct*nums[i];
                    posprdct = temp;
                    posprdctset = true;
                }
            } else if (nums[i] == 0) {
                posprdct = 1;
                negprdct = 1;
                if(0 > max) max = 0;
                continue;
            } else {
                posprdct *= nums[i];
                if(negprdct !=1) negprdct *= nums[i];
                posprdctset = true;
            }
            if(posprdctset && posprdct > max) {
                max = posprdct;
            }
        }

        return max;
    }
}
