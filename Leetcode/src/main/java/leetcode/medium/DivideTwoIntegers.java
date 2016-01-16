package leetcode.medium;

/**
 * Created by jai around 11/9/15.
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend==Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (divisor == -1) return 0-dividend;
        boolean signchange=false;
        if((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) signchange = true;
        long num = dividend;
        long den = divisor;
        if(num < 0) num = 0-num;
        if(den < 0) den = 0-den;
        if(num == 0 || den > num) return 0;
        long q = 0;
        long qo = 0;
        long ans = 0;
        do {
            while(num-q >= q) {
                if(q==0) {
                    q+=den;
                    qo=1;
                } else {
                    q+=q;
                    qo<<=1;
                }
            }
            ans+=qo;
            num-=q;
            q=0;
            qo=0;
        }while(num >= den);
        return (int)(signchange ? 0-ans:ans);
    }
}
