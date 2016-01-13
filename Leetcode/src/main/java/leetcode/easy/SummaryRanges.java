package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jai around 9/28/15.
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) {
            return list;
        }
        int start, end;
        start = nums[0];
        if (nums.length == 1) {
            end = start;
            list.add(getrange(start,end));
            return list;
        }
        for (int i = 1; i < nums.length; i++) {
            if(i == nums.length-1) {
                if(nums[i] - nums[i-1] == 1) {
                    end = nums[i];
                } else {
                    end = nums[i-1];
                    list.add(getrange(start,end));
                    start = end = nums[i];
                }
                list.add(getrange(start,end));
            } else if(nums[i] - nums[i-1] != 1) {
                end = nums[i-1];
                list.add(getrange(start,end));
                start = nums[i];
            }
        }
        return list;
    }

    private String getrange(int start, int end) {
        if (start == end) {
            return ""+ start;
        } else {
            return start + "->" + end;
        }
    }
}
