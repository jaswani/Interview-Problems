package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
 * (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long val = getUnsignedInt(n);
        long rev = 0;
        for(int i= 0; i < 32; i++) {
            rev <<= 1;
            if ((val & 0x01) == 0x01) {
                rev |= 0x01;
            }
            val >>= 1;
        }
        return (int)rev;
    }

    public long getUnsignedInt(int x) {
        return x & 0x00000000ffffffffL;
    }
}
