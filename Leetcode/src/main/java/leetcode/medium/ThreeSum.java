package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jai around 10/5/15.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length == 0 || nums[0] > 0 || nums[nums.length-1] < 0) return ret;
        int i=0, j , k;
        while(i < nums.length) {
            j = i+1; k = nums.length-1;
            while(j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    //found
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    ret.add(l);
                    while(j < nums.length-1 && nums[j] == nums[j+1]) j++;
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
            while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
            i++;
        }
        return ret;
    }
}
