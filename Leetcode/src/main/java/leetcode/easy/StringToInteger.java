package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 */
public class StringToInteger {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length() == 0) return 0;
        int i = 0;
        long sum =0;
        int neg = 1;
        if(s.charAt(0) == '-') {
            neg = -1;
            i = 1;
        } else if(s.charAt(0) == '+') {
            neg = 1;
            i = 1;
        }
        for(; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) break;;
            sum = sum*10 + s.charAt(i) - '0';
            if(sum > Integer.MAX_VALUE) break;
        }
        sum = sum*neg;
        if(sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)sum;
    }
}
