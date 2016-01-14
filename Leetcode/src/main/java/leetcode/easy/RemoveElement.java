package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0,j = nums.length-1;
        while(i <= j) {
            if(nums[i] == val) {
                nums[i] = nums[j--];
                // a[j--] = val;
                continue;
            }
            i++;
        }
        return j+1;
    }
}
