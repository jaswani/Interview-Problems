package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * For example:
 *
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if(nums.length < 3) return nums;
        long xor = longnum(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            xor ^=longnum(nums[i]);
        }
        long x = 1;
        while (x <= xor) x<<=1;
        x>>=1;
        long xor1=0, xor2=0;
        for(int i =0; i < nums.length; i++) {
            long n = longnum(nums[i]);
            if((x & n) == x) xor1 ^= n;
            else xor2 ^= n;
        }
        int [] ret = {(int)xor1, (int)xor2};
        return ret;

    }

    private long longnum(int n) {
        return 0x00000000FFFFFFFFL & n;
    }
}
