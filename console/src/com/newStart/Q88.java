package com.newStart;

public class Q88 {
    public static void main(String[] args) {
        Q88 test=new Q88();
        int[] a=new int[]{1,2,3,0,0,0};
        int[] b=new int[]{-5,-2,-1};
        test.merge(a,3,b,3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
