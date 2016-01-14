package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        StringBuilder st = new StringBuilder();
        int addIndex1 = numRows;
        int addIndex2 = numRows-2;
        int betaIndex = 0;
        for(int i =0; i < numRows; i++) {
            int index1 = 0, index2 = 0;
            if (addIndex2 < 0) {
                index1 = index2 = betaIndex;
            } else if(betaIndex == 0){
                index1 = index2 = addIndex1 + addIndex2;
            } else {
                index1 = addIndex1 + addIndex2;
                index2 = betaIndex;
            }
            boolean flag =true;
            int j = i;
            while(j<s.length()) {
                st.append(s.charAt(j));
                if(flag) {
                    j+=index1;
                    flag = false;
                } else {
                    j+=index2;
                    flag = true;
                }
            }
            addIndex1--; addIndex2--;
            betaIndex+=2;
        }
        return st.toString();
    }
}
