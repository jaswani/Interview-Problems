package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        if(n == 2) return "11";
        String prev = "11";
        for(int j = 2; j < n; j++) {
            StringBuilder curr = new StringBuilder();
            int i =1;
            int count = 1;
            for(; i < prev.length(); i++) {
                if(prev.charAt(i-1) == prev.charAt(i)) {
                    count++;
                } else {
                    curr.append(count).append(prev.charAt(i-1));
                    count = 1;
                }
            }
            curr.append(count).append(prev.charAt(i-1));
            prev = curr.toString();
        }
        return prev;
    }
}
