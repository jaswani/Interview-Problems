package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jai around 10/5/15.
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.
 */
public class DifferentWaysToAddParenthesis {
    private Map<String, List<Integer>> hm = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> l = hm.get(input);
        if(l != null) return l;
        l = new ArrayList<>();
        // if(input.length() == 1) {
        //     l.add(input.charAt(0) - '0');
        //     return l;
        // }
        boolean alldigits = true;
        int sum = 0;
        for(int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum*10 + c-'0';
                continue;
            }
            if(c != '*' && c != '-' && c != '+') return l; //.isEmpty() ? null : l;
            alldigits = false;
            List<Integer> l1,l2;
            l1 = diffWaysToCompute(input.substring(0, i));
            l2 = diffWaysToCompute(input.substring(i+1, input.length()));
            for(int j : l1) {
                for(int k : l2) {
                    switch(c) {
                        case '*' : l.add(j*k); break;
                        case '+' : l.add(j+k); break;
                        case '-' : l.add(j-k); break;
                    }
                }
            }
        }
        Collections.sort(l);
        if(alldigits) l.add(sum);
        else hm.put(input, l);
        return l;
    }
}
