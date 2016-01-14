package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);
        for(int i = 1; i < numRows; i++) {
            List<Integer> prevl = list.get(i-1);
            l = new ArrayList<>();
            l.add(1);
            for(int j = 1; j < i; j++) {
                l.add(prevl.get(j-1) + prevl.get(j));
            }
            l.add(1);
            list.add(l);
        }
        return list;
    }
}
