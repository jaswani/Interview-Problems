package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai around 9/28/15.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap, tmap;
        smap = createMap(s);
        tmap = createMap(t);
        if (smap.size() != tmap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            if (tmap.get(entry.getKey()) == null || entry.getValue().intValue() != tmap.get(entry.getKey()).intValue()) {
                return false;
            }
        }
        return true;

    }

    private Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> charmap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            Integer x = charmap.get(str.charAt(i));
            if( x != null) {
                charmap.put(str.charAt(i), x+1);
            } else {
                charmap.put(str.charAt(i), 1);
            }
        }
        return charmap;
    }
}
