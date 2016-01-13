package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jai around 9/28/15.
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        // for (int i = 0; i < nums.length; i++) {
        //     for(int j = i+1; j < min(nums.length, i+k+1) ; j++) {
        //         if(nums[j] == nums[i]) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if(hm.get(nums[i]) != null) {
                for(int j : hm.get(nums[i])) {
                    if(i - j <= k) {
                        return true;
                    }
                }
                hm.get(nums[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                hm.put(nums[i], l);
            }
        }
        return false;
    }

    // private int min(int a, int b) {
    //     if (a > b) {
    //         return b;
    //     }
    //     return a;
    // }
}
