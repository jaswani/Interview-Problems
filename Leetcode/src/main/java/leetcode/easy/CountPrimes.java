package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    List<Integer> l = new ArrayList<Integer>();
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(checkPrime(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean checkPrime(int val) {
        for(int div : l) {
            if (val % div == 0) {
                return false;
            }
            if(div*div > val) {
                break;
            }
        }
        l.add(val);
        return true;
    }
}

