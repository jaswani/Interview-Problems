package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> ans = new ArrayList<>();
        int i = digits.length -1;
        while(i >= 0) {
            int sum = carry + digits[i--];
            ans.add(0,sum%10);
            carry = sum > 9 ? 1 : 0;
        }
        if(carry == 1) ans.add(0,carry);
        int [] ret  = new int[ans.size()];
        for(i= 0; i < ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }
}
