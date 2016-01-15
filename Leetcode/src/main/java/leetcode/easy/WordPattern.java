package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai around 10/5/15.
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in
 * str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single
 * space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> cs = new HashMap<>();
        Map<String, Character> sc = new HashMap<>();
        str.trim();
        String[] s = str.split(" ");
        if(s.length != pattern.length()) return false;
        for(int i=0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String val = s[i];
            if (cs.get(c) == null) {
                if(sc.get(val) != null) return false;
                cs.put(c, val);
                sc.put(val,c);
            } else if (!cs.get(c).equals(val)) return false;
        }
        return true;
    }
}
