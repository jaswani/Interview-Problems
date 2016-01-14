package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        long d=10;
        long count = 0;
        int x = n;
        while(x > 0) {
            long q = n%d;
            count += (n/d)*(d/10);
            if(q - d/10 >=  d/10) {
                count += d/10;
            } else if(q-d/10 >= 0) {
                count += q - d/10 + 1;
            }
            d *=10;
            x /=10;
        }
        return (int)count;
    }
}
