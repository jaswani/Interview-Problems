package leetcode.medium;

/**
 * Created by jai around 9/28/15.
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HindexII {
    public int hIndex(int[] citations) {
        int low = 1, high = citations.length;
        while(low <=  high) {
            int mid = (low + high) / 2;
            int index = binSearch(mid, citations);
            if(index == -1) {
                high = mid-1;
                continue;
            }
            if (citations.length - index == mid)
                return mid;
            //mid not found:
            if(citations[index] != mid) {
                if (citations.length - index > mid)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else { //found
                if (citations.length - index > mid) {
                    int iter = index;
                    while(iter < citations.length && citations[iter] == mid) {
                        iter++;
                    }
                    if(citations.length - iter <= mid) {
                        return mid;
                    }
                    low = mid +1;
                } else {
                    int iter = index;
                    while(iter > -1 && citations[iter] == mid) {
                        iter--;
                    }
                    if(iter == -1) {
                        return mid;
                    } else if(citations.length - iter -1 >= mid) {
                        return mid;
                    }
                    high = mid -1;
                }
            }
        }
        return 0;
    }

    private int binSearch(int val, int[] c) {
        int low = 0;
        int high = c.length-1;
        while(low < high) {
            int mid = (low+high)/2;
            if (c[mid] == val) {
                return mid;
            } else if(c[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(c[low] < val)
            if(low == c.length -1) low= -1;
            else low++;
        return low;
    }
}
