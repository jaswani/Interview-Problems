package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder st = new StringBuilder();
        if(n < 1) return st.toString();
        while(n > 26) {
            int val = n%26;
            if(val == 0) val = 26;
            st.append(Character.toChars(val+64));
            n -=val;
            n /= 26;
        }
        if(n>0) st.append(Character.toChars(n+64));
        return st.reverse().toString();
    }
}
