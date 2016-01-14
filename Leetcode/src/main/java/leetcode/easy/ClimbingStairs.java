package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    // public int climbStairs(int n) {
    //     if(n <=1) return  1;
    //     return climbStairs(n-1) + climbStairs(n-2);
    // }

    public int climbStairs(int n) {
        if(n <=1) return  1;
        int iminus1 = 1;
        int iminus2 = 1;
        for(int i=2; i<=n; i++) {
            int curr = iminus1 + iminus2;
            iminus2 = iminus1;
            iminus1 = curr;
        }
        return iminus1;
    }
}
