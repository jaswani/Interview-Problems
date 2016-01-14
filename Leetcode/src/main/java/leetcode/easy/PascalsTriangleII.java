package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList();
        if (rowIndex == 0) return list;
        list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i < rowIndex; i++) {
            List<Integer> prevl = list;
            list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j < i; j++) {
                list.add(prevl.get(j-1) + prevl.get(j));
            }
            list.add(1);
        }
        return list;
    }
}
