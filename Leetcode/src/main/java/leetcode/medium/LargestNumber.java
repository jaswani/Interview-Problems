package leetcode.medium;

/**
 * Created by jai around 10/19/15.
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        quicksort(0, nums.length-1, nums);
        String ans = "";
        for(int i = 0; i < nums.length; i++) ans += nums[i];
        boolean allzero = true;
        for(int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) != '0') {
                allzero = false;
                break;
            }
        }
        if(allzero) return "0";
        return ans;
    }

    private void quicksort(int l, int h, int[] n) {
        if(l > h) return;
        int low = l;
        int high = h;
        int pivot = n[high];
        int pivotindex = high;
        high--;
        while(low <= high) {
            if(cmp(n[low],pivot) == 1) {
                low++;
            } else {
                int temp = n[low];
                n[low] = n[high];
                n[high] = temp;
                high--;
            }
        }
        int temp = n[pivotindex];
        n[pivotindex] = n[low];
        n[low] = temp;
        quicksort(l, low-1, n);
        quicksort(low+1, h, n);
    }

    private int getVal(int n) {
        while(n >= 10) n /= 10;
        return n;
    }

    private int cmp(int ax, int bx) {
        long a = ax;
        long b = bx;
        if (a == b) return 0;
        if (a == 0) return -1;
        if (b == 0) return 1;
        long na = 1;
        while(a >= 1) {
            a /= 10;
            na *= 10;
        }

        long nb = 1;
        while(b >= 1) {
            b /= 10;
            nb *= 10;
        }

        if(ax*nb+bx > bx*na+ax) {
            return 1;
        } else {
            return -1;
        }
    }
}
