package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 *
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int value = 0, factor = 1;
        StringBuilder st = new StringBuilder(s);
        s = st.reverse().toString();
        for(int i = 0; i < s.length(); i++) {
            value += factor*(s.charAt(i) - 64);
            factor *= 26;
        }
        return value;
    }
}
