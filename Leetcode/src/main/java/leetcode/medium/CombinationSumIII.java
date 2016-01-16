package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jai around 10/19/15.
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.
 *
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    private Integer [] l;
    private int len;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        len = k;
        l = new Integer[k];
        ans = new ArrayList<>();
        combSum(0, n, 1);
        return ans;
    }

    private void combSum(int index, int n,  int start) {
        if (index == len) {
            if (n == 0) {
                ans.add(new ArrayList<Integer>(Arrays.asList(l)));
            }
        } else {
            for (int i = start; i < 10; i++) {
                l[index] = i;
                combSum(index+1, n-i, i+1);
            }
        }
    }
}
