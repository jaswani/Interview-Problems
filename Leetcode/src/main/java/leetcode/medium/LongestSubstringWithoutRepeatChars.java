package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai around 10/5/15.
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest
 * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatChars {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0, curlen = 0, start = -1, end = -1;
        int mstart = -1, mend = -1;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hm.get(c) == null || hm.get(c) < start) {
                //new entry
                curlen++;
                if(start == -1) start = i;
                end = i;
                hm.put(c, i);
            } else {
                //repeat, remove all previous occurences of this
                start = hm.get(c) + 1;
                end = i;
                curlen = end-start+1;

                hm.put(c,i);
            }
            if(curlen > maxlen) {
                mstart = start;
                mend = end;
                maxlen = curlen;
            }
        }
        return maxlen;
    }
}
