package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the
 * Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function
 * should return 3.
 */
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long n2 = getUnsignedInt(n);
        int count = 0;
        while(n2 > 0) {
            if((n2 & 1) == 1) {
                count++;
            }
            n2 = n2 >> 1;
        }
        return count;
    }
    private long getUnsignedInt(int x) {
        return x & 0x00000000ffffffffL;
    }
}
