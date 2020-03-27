package com.sesshou.leetcode;

/**
 * @author wp41128
 * @date 2020/3/20 11:39
 * @description：合并2个排序数组
 */
public class Merge_Sorted_Array {
    public static void main(String[] args) {
        Merge_Sorted_Array test = new Merge_Sorted_Array();
        int[] nums1 = new int[]{2, 0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        test.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] result = new int[m + n];
        int index = 0;
        while (index < m + n ) {
            if(i<m&&j<n){
                if(nums1[i] < nums2[j]){
                    result[index] = nums1[i];
                    i++;
                }else{
                    result[index] = nums2[j];
                    j++;
                }
            }else if(i==m){
                result[index] = nums2[j];
                j++;
            }else if(j==n){
                result[index] = nums1[i];
                i++;
            }
            index++;
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }
}
