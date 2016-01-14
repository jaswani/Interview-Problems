package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jai around 10/5/15.
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {
    private Map<Integer, String> hm = new HashMap<>();

    public String numberToWords(int num) {
        if(num > Integer.MAX_VALUE || num < 0) return "";
        if(num == 0) return "Zero";
        hm.put(1,"One");
        hm.put(2,"Two");
        hm.put(3,"Three");
        hm.put(4,"Four");
        hm.put(5,"Five");
        hm.put(6,"Six");
        hm.put(7,"Seven");
        hm.put(8,"Eight");
        hm.put(9,"Nine");
        hm.put(10,"Ten");
        hm.put(11,"Eleven");
        hm.put(12,"Twelve");
        hm.put(13,"Thirteen");
        hm.put(14,"Fourteen");
        hm.put(15,"Fifteen");
        hm.put(16,"Sixteen");
        hm.put(17,"Seventeen");
        hm.put(18,"Eighteen");
        hm.put(19,"Nineteen");
        hm.put(20,"Twenty");
        hm.put(30,"Thirty");
        hm.put(40,"Forty");
        hm.put(50,"Fifty");
        hm.put(60,"Sixty");
        hm.put(70,"Seventy");
        hm.put(80,"Eighty");
        hm.put(90,"Ninety");
        hm.put(100,"Hundred");
        hm.put(1000,"Thousand");
        hm.put(1000000,"Million");
        hm.put(1000000000,"Billion");
        // StringBuilder st = new StringBuilder();
        String s = "";
        int count = 0;
        while(num > 0) {
            int x = num%1000;
            String w = numToWords3(x);
            switch(count) {
                case 0: s = w; break;
                case 1: s = w.trim().isEmpty() ? s : w + " " + hm.get(1000) + s; break;
                case 2: s = w.trim().isEmpty() ? s : w + " " + hm.get(1000000) + s; break;
                case 3: s = w.trim().isEmpty() ? s : w + " " + hm.get(1000000000) + s; break;
            }
            num /=1000;
            count++;
        }

        return s.trim();
    }

    private String numToWords3(int num) { //n < 1000
        String s = "";
        int divisor = 10;
        String curr = hm.get(num%100);
        if(curr != null) {
            s = " " + curr;
            num -= num%100;
            divisor = 1000;
            // return hm.get(1);
        }
        while(divisor < 1000) {
            int d = num%divisor;
            divisor *=10;
            if(d == 0) {
                continue;
            }
            s = " " + hm.get(d) + s;
            num -= d;
        }
        //divisor is equal to 1000
        if (num > 0) {
            s = " " + hm.get(num/100) + " " + hm.get(100) + s;
        }
        return s;
    }
}
