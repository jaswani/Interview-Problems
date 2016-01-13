package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {
    public int addDigits(int num) {
        while(true) {
            int sum = 0;
            while(num >= 10) {
                sum += num%10;
                num /=10;
            }
            sum += num;
            if (sum >= 10) {
                num = sum;
            } else {
                return sum;
            }
        }
    }
}
