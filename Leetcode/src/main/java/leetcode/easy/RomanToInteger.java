package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
        int sum = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            int x = getVal(s.charAt(i));
            if(i == s.length()-1) sum += x;
            else {
                if(getVal(s.charAt(i+1)) > x) sum -=x;
                else sum += x;
            }
        }
        return sum;
    }

    private int getVal(char c) {
        switch(c) {
            case 'I':
                // case 'i':
                return 1;
            case 'V':
                // case 'v':
                return 5;
            case 'X':
                // case 'x':
                return 10;
            case 'L':
                // case 'l':
                return 50;
            case 'C':
                // case 'c':
                return 100;
            case 'D':
                // case 'd':
                return 500;
            case 'M':
                // case 'm':
                return 1000;
            default:
                return 0;
        }
    }
}
