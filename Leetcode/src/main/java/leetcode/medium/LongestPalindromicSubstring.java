package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
    int mstart =0, mend = 0, maxlen = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int i=0,j=0, x =0;
        while(x < s.length()) {
            if(i == j) {
                //new palindrome sequence
                while(i < s.length()-1 && s.charAt(i+1) == s.charAt(i)) i++;
                if(i != j) {
                    //same char
                    checkMax(i,j);
                }
                x = i+1;
            }
            //old sequence continued
            if (j > 0 && i < s.length() - 1) {
                if(s.charAt(j - 1) == s.charAt(i + 1)){
                    j--; i++;
                    checkMax(i,j);
                } else {
                    //palindrom breaks, reset
//                    j = ++i;
                    j = i = x;
                }
            }
            //reached end reset
            if(i == s.length()-1) {
                break;
            }
            if(j == 0) {
                j = i = x;
            }
        }
        return s.substring(mstart,mend+1);
    }

    private void checkMax(int i, int j) {
        if(i-j+1 > maxlen) {
            mstart = j;
            mend = i;
            maxlen = i-j+1;
        }
    }
}
