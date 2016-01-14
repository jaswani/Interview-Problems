package leetcode.easy;

import java.util.Stack;

/**
 * Created by jai around 10/5/15.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
 * is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                case '{':
                case '[':
                    st.push(c);
                    break;
                case ')':
                    if(st.empty() || st.pop() != '(') return false;
                    break;
                case '}':
                    if(st.empty() || st.pop() != '{') return false;
                    break;
                case ']':
                    if(st.empty() || st.pop() != '[') return false;
                    break;
                default:
                    return false;
            }
        }
        return st.empty();
    }
}
