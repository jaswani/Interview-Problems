package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int move = nums.length;
        int cycle = 1;
        if(k == 0) return;
        if (move % k == 0) {
            cycle = k;
        } else {
            cycle = move%k;
        }
        //  int i = 0;
        //  int val = nums[i];
        for(int i = 0; i < cycle; i++) {
            int val = nums[i];
            int start = i;
            while(move > 0) {
                i = (i+k)%nums.length;
                int temp = nums[i];
                nums[i] = val;
                val = temp;
                move--;
                if (i == start) {
                    //cycle repeat
                    break;
                }
            }
        }
    }
}
