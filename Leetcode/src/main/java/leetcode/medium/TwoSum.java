package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {;
        int i =0 ,j = 0;
        boolean found = false;
        for(i = 0; i < nums.length; i++) {
            for(j = i+1; j < nums.length; j++ ) {
                if(nums[i] + nums[j] == target) {
                    found = true;
                    break;
                }
            }
            if(found == true) break;
        }

        int[] ret = {i+1, j+1};
        return ret;
    }
}
