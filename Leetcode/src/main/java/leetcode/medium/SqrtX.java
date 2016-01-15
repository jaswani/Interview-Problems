package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if(x < 2) return x;
        long bit = 0x01;
        while(bit*bit < x) bit<<=1;
        if(bit*bit == x) return (int)bit;
        bit>>=1;
        long val = bit;
        while(bit > 1) {
            bit >>= 1;
            long root = val | bit;

            if(root * root <= x) {
                val = root;
            }
        }
        return (int)val;
    }
}
