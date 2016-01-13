package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai around 9/28/15.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ConatinsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hm.get(nums[i]) != null) {
                return true;
            }
            hm.put(nums[i], new Integer(1));
        }
        return false;

    }
}
