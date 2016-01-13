package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x, sum = 0;
        while(y > 0) {
            sum = sum*10+ y%10;
            y /= 10;
        }
        return (sum == x);
    }
}
