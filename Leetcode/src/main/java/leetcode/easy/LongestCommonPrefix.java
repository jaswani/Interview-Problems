package leetcode.easy;

/**
 * Created by jai on 9/28/15.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder st = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean done = false;
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != c) {
                    done = true;
                    break;
                }
            }
            if(done == true) {
                break;
            } else {
                st.append(c);
            }
        }
        return st.toString();
    }
}
