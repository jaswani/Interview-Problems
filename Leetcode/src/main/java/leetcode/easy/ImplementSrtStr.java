package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementSrtStr {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(cmp(haystack, i, needle) == true) return i;
        }
        return -1;
    }

    private boolean cmp(String h, int i, String n) {
        int j = 0;
        while(j < n.length() && i < h.length()) {
            if (n.charAt(j++) != h.charAt(i++)) return false;
        }
        return (j == n.length());
    }
}
