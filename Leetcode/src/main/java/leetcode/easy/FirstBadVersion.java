package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
 * version of your product fails the quality check. Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    private boolean isBadVersion(int version) {
        //given by leetcode..
        return false;
    }
    public int firstBadVersion(int n) {
        if (isBadVersion(0)) {
            return 0;
        }
        if(!isBadVersion(n)) {
            //no bad versions
            return -1;
        }
        return binSearch(0,n);
    }

    private int binSearch(int low, int high) {
        int mid =  low + (high-low)/2;
        if(mid == 0 && isBadVersion(0)) {
            return mid;
        }
        if(mid!=0 && !isBadVersion(mid-1) && isBadVersion(mid)) {
            return mid;
        }
        if(!isBadVersion(mid)) {
            return binSearch(mid+1, high);
        } else {
            return binSearch(low, mid-1);
        }
    }
}
