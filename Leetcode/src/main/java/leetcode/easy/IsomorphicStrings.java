package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai  around 9/28/15.
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<Character, Character>();
        Map<Character, Character> hm2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if(hm.get(s.charAt(i)) == null) {
                //no entry
                if(hm2.get(t.charAt(i)) == null) {
                    hm.put(s.charAt(i), t.charAt(i));
                    hm2.put(t.charAt(i), s.charAt(i));
                } else {
                    return false;
                }
            } else {
                if(0 != hm.get(s.charAt(i)).compareTo(t.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
