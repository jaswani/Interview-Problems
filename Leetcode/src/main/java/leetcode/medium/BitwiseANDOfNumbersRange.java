package leetcode.medium;

/**
 * Created by jai around 10/19/15.
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) return m;
        if( m ==0 || n==0) return 0;
        if(n-m == 1) return m&n;
        int mx = 1;
        int a = 0;
        while(n-m >= mx && mx <= m) {
            a |= mx;
            mx<<=1;
        }
        return (m & ~a & n);
    }
}
