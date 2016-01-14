package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        long sum = 0;
        int mult = 1;
        if(x < 0) {
            mult = -1;
            x *=mult;
        }

        while(x > 0) {
            sum = sum*10 + x%10;
            if(sum > Integer.MAX_VALUE) return 0;
            x /= 10;
        }

        return (int)sum*mult;
    }
}
