package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Majorityelement {
    public int majorityElement(int[] nums) {
        if (nums.length % 2 == 0)
            return rank(nums, 0, nums.length-1, nums.length/2-1);
        return rank(nums, 0, nums.length-1, nums.length/2);
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
}
