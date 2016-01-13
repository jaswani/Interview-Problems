package leetcode.medium;

/**
 * Created by jai around 9/28/15.
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] minArray = new int[n+1];
        minArray[0] = 0;
        for(int i = 1; i < n+1; i++) {
            minArray[i] = Integer.MAX_VALUE;
            for(int j = 1; (j*j <= i); j++) {
                if(j*j == i) {
                    minArray[i] = 1;
                } else {
                    int sum = minArray[j*j] + minArray[i-j*j];
                    if (sum < minArray[i]) {
                        minArray[i] = sum;
                    }
                }
            }
        }
        return minArray[n];
    }
}
