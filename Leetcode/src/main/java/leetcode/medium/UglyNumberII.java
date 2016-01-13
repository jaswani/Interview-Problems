package leetcode.medium;

/**
 * Created by jai around 9/28/15.
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII {
    int[] count = {0,0,0,0,0,0};
    public int nthUglyNumber(int n) {
        if(n == 0) {
            return 0;
        }
        int[] al = new int[n];
        al[0] = 1;
        for (int i = 1; i < n; i++) {
            al[i] = nextUgly(al);
        }
        return al[n-1];

    }

    public int nextUgly(int[] al) {
        int val = 2;
        if(val*al[count[val]] == 3*al[count[3]]) {
            count[3]++;
        }
        if(val*al[count[val]] > 3*al[count[3]]) {
            val = 3;
        }
        if(val*al[count[val]] == 5*al[count[5]]) {
            count[5]++;
        }
        if(val*al[count[val]] > 5*al[count[5]]) {
            val = 5;
        }
        int retVal = val*al[count[val]];
        count[val]++;
        return retVal;
    }
}
