package leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jai around 10/5/15.
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // if(nums.length == 0 || k == 0) return false;
        if(t<0) return false;
        TreeMap<Long,Long> s = new TreeMap<>();
        for(int i = 0; i < Math.min(nums.length, k+1); i++) {
            Map<Long,Long> temp;
            // if(t>0) {
            temp = s.subMap((long)nums[i]-t, (long)nums[i]+t+1);
            if(!temp.isEmpty()) return true;
            // }
            // else {
            //     temp = s.headMap(nums[i]+t+1);
            //     if(!temp.isEmpty()) return true;
            //     temp = s.tailMap(nums[i]-t);
            //     if(!temp.isEmpty()) return true;
            // }
            if(s.get((long)nums[i]) != null) {
                s.put((long)nums[i],s.get((long)nums[i])+1);
            } else {
                s.put((long)nums[i],1L);
            }
            // if(s.get(nums[i]) != null) return true;
            // if(s.get(nums[i]+t) != null) {
            //     s.put(nums[i]+t,s.get(nums[i]+t)+1);
            // } else {
            //     s.put(nums[i]+t,1);
            // }
            // if(s.get(nums[i]-t) != null) {
            //     s.put(nums[i]-t,s.get(nums[i]-t)+1);
            // } else {
            //     s.put(nums[i]-t,1);
            // }
        }

        int i = 0;
        for(int j=k+1; j < nums.length; j++) {
            if(s.get((long)nums[i]) == 1) {
                s.remove((long)nums[i]);
            } else {
                s.put((long)nums[i],s.get((long)nums[i])-1);
            }
            i++;

            Map<Long,Long> temp;
            temp = s.subMap((long)nums[j]-t, (long)nums[j]+t+1);
            if(!temp.isEmpty()) return true;
            // if(t>0) temp = s.subMap(nums[i]-t, nums[i]+t+1);
            // else  temp = s.headMap(nums[i]+t+1);
            // if(!temp.isEmpty()) return true;
            // temp = s.tailMap(nums[i]-t);
            // if(!temp.isEmpty()) return true;
            if(s.get((long)nums[j]) != null) {
                s.put((long)nums[j],s.get((long)nums[j])+1);
            } else {
                s.put((long)nums[j],1L);
            }

            // if(s.get(nums[i]+t) == 1) s.remove(nums[i]+t);
            // else s.put(nums[i]+t,s.get(nums[i]+t)-1);

            // if(s.get(nums[i]-t) == 1) s.remove(nums[i]-t);
            // else s.put(nums[i]-t,s.get(nums[i]-t)-1);
            // i++;
            // if(s.get(nums[j]) != null) return true;
            // if(s.get(nums[j]+t) != null) {
            //     s.put(nums[j]+t,s.get(nums[j]+t)+1);
            // } else {
            //     s.put(nums[j]+t,1);
            // }
            // if(s.get(nums[j]-t) != null) {
            //     s.put(nums[j]-t,s.get(nums[j]-t)+1);
            // } else {
            //     s.put(nums[j]-t,1);
            // }

        }
        return false;
    }
}
