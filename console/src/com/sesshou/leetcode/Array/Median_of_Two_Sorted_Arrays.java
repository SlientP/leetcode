package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/24 15:53
 * @description：two sorted array mid num
 */
public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays test = new Median_of_Two_Sorted_Arrays();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-1, 3};
        System.out.println(test.findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int templength = m;
            m = n;
            n = templength;
        }
        int iMin = 0;
        int iMax = m;
        int halflen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int j = halflen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0L;
    }
}
