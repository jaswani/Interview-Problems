package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 10/5/15.
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in
 * linear time and in O(1) space.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        if(nums.length < 1) return l;
        int a = rank(nums, 0, nums.length-1, nums.length/3);
        int b = rank(nums, 0, nums.length-1, 2*nums.length/3);
        if (count(nums,a) > nums.length/3) l.add(a);
        if (a!=b && count(nums,b) > nums.length/3) l.add(b);
        return l;
    }

    private int rank(int[] nums, int start, int end, int r) {
        if(start > end) return 0;
        if(start == end) return nums[start];
        int pivot = nums[end];
        int low = start;
        int high = end-1;
        boolean earliestPossible = false;
        int earliestRank = -1, latestRank = -1;
        while(low <= high) {
            if (nums[low] < pivot) {
                if(earliestPossible) {
                    int temp = nums[low];
                    nums[low] = nums[earliestRank];
                    nums[earliestRank] = temp;
                    if(earliestRank == latestRank) {
                        earliestRank = latestRank = low;
                    } else {
                        earliestRank++;
                        latestRank = low;
                    }
                }
                low++;
            } else if(nums[low] > pivot){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                high--;
            } else {
                //equal to pivot
                if(!earliestPossible) {
                    earliestPossible = true;
                    earliestRank = latestRank = low;
                } else {
                    latestRank = low;
                }
                low++;
            }
        }
        int temp = nums[low];
        nums[low] = pivot;
        nums[end] = temp;
        if (low == r) {
            return pivot;
        }
        if(earliestPossible && isBetween(r, earliestRank, low)) {
            return pivot;
        }
        if (low > r) {
            if(earliestPossible) return rank(nums, start, earliestRank-1, r);
            return rank(nums, start, low-1, r);
        } else {
            return rank(nums, low+1, end, r);
        }
    }

    private boolean isBetween(int val, int low, int high) {
        if (val >= low && val <= high) {
            return true;
        }
        return false;
    }

    private int count(int [] nums, int val) {
        int count = 0;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] == val) count++;
        }
        return count;
    }
}
