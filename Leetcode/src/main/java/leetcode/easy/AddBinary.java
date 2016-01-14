package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder st = new StringBuilder();
        while(i >=0 || j >=0) {
            int s1 = i < 0 ? 0 : (a.charAt(i) == '0' ? 0 : 1);
            int s2 = j < 0 ? 0 : (b.charAt(j) == '0' ? 0 : 1);
            switch(s1+s2+carry) {
                case 0:
                    st.append('0');
                    carry = 0;
                    break;
                case 1:
                    st.append('1');
                    carry = 0;
                    break;
                case 2:
                    st.append('0');
                    carry = 1;
                    break;
                case 3:
                    st.append('1');
                    carry = 1;
                    break;
                default:
            }
            i--; j--;
        }
        if(carry == 1) {
            st.append(1);
        }
        return st.reverse().toString();
    }
}
