package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int div= 1000;
        String ans = "";
        while(div > 0) {
            int q = num/div;
            if(q >5 && q<9) {
                //additional round
                q=num/(5*div);
                for(int i=0; i<q; i++) ans += getChar(5*div);
                num %=(5*div);
                continue;
            }
            if(q == 9 || q == 4 || q == 5) ans+=getChar(q*div);
            else {
                for(int i=0; i<q; i++) ans += getChar(div);
            }
            num %=div;
            div /= 10;
        }
        return ans;
    }

    private String getChar(int r) {
        switch(r) {
            case 1000:
                return "M";
            case 900:
                return "CM";
            case 500:
                return "D";
            case 400:
                return "CD";
            case 100:
                return "C";
            case 90:
                return "XC";
            case 50:
                return "L";
            case 40:
                return "XL";
            case 10:
                return "X";
            case 9:
                return "IX";
            case 5:
                return "V";
            case 4:
                return "IV";
            case 1:
                return "I";
            default:
                return "";
        }
    }
}
