package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count  = 0;
        if (n == 0) return 0;
        while((n = n/5) > 0) {
            count+= n;
        }
        return count;
    }
}
