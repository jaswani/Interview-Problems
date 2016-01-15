package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        return findRank(0, nums.length-1, k-1, nums);
    }


    private boolean isbetween(int val, int min, int max) {
        return val >= min && val <= max;
    }

    private int findRank(int low, int high ,int k , int [] nums) {
        // Random r = new Random(System.currentTimeMillis());
        int l = low;
        int h = high;

        // int pivot = l==h ? l : r.nextInt(h-l) + l;
        // swap(pivot, h, nums);
        int pivot = h;
        h--;
        boolean earliestFound = false;
        int elow = -1, ehigh = -1;
        while(l <= h) {
            if (nums[l] > nums[pivot]) {
                if(earliestFound) {
                    swap(elow, l, nums);
                    if(elow == ehigh) elow = ehigh = l;
                    else {
                        elow++;
                        ehigh = l;
                    }
                }
                l++;
            } else if (nums[l] < nums[pivot]) {
                swap(l, h, nums);
                h--;
            } else {
                if(!earliestFound) {
                    earliestFound = true;
                    elow = ehigh = l;
                } else {
                    ehigh = l;
                }
                l++;
            }
        }

        //l is the place where the pivot should be
        swap(l, pivot, nums);
        if(earliestFound) {
            if(isbetween(k, elow, l)) return nums[l];
        } else {
            if (k == l) return nums[l];
        }

        if(earliestFound) {
            if(elow > k) {
                return findRank(low, elow-1, k, nums);
            } else {
                return findRank(l+1, high, k, nums);
            }
        } else {
            if (l > k) {
                return findRank(low, l-1, k, nums);
            } else {
                return findRank(l+1, high, k, nums);
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
