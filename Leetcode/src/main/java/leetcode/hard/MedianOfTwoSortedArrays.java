package leetcode.hard;

/**
 * Created by jai around 10/5/15.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        double sum = findRank(nums1,nums2,(nums1.length+nums2.length)/2+1);
        if((nums1.length+nums2.length)%2 == 0) {
            sum += findRank(nums1, nums2, (nums1.length + nums2.length) / 2);
            sum /= 2;
        }
        return sum;
    }

    public int findRank(int[] n1, int[] n2, int r) {
        int l1 =0, l2 =0, h1=n1.length-1, h2=n2.length-1;
        while(l1<=h1 && l2<=h2) {
            int m1 = (l1+h1)/2;
            int m2 = (l2+h2)/2;
            int rank = m1+m2+1;
            if(n1[m1] > n2[m2]) {
                if(rank == r) {
                    l2 = m2;
                } if(rank < r) {
                    l2 = m2+1;
                }else {
                    //Should never happen
                    // System.out.println("wrong!");
                }
                rank++;
                if(rank == r) {
                    if(m1 !=l1) h1 = m1;
                } if(rank > r) {
                    h1 = m1-1;
                }else {
                    //Should never happen
                    // System.out.println("wrong!!");
                }
            } else {
                if(rank == r) {
                    l1 = m1;
                } if(rank < r) {
                    l1 = m1+1;
                }else {
                    //Should never happen
                    // System.out.println("wrong!!!");
                }
                rank++;
                if(rank == r) {
                    if(m2 !=l2) h2 = m2;
                } if(rank > r) {
                    h2 = m2-1;
                }else {
                    //Should never happen
                    // System.out.println("wrong!!!!");
                }
            }
        }
        if(l1 > h1) {
            while(l2 <= h2) {
                int mid  = (l2 + h2)/2;
                if(r == mid+l1+1) {
                    return n2[mid];
                } else if(r < mid+l1+1) {
                    h2 = mid-1;
                } else { // val > mid
                    l2 = mid+1;
                }
            }
        }

        if(l2 > h2) {
            while(l1 <= h1) {
                int mid  = (l1 + h1)/2;
                if(r == mid+l2+1) {
                    return n1[mid];
                } else if(r < mid+l2+1) {
                    h1 = mid-1;
                } else { // val > mid
                    l1 = mid+1;
                }
            }
        }
        return -1;
    }
}
