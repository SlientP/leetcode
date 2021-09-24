package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/27 8:36
 * @description：
 */
public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int L = 0;
        int R = 0;
        while (R < len ) {
            while (R < len - 1 && nums[R] == nums[R + 1]) {
                R++;
            }
            nums[L] = nums[R++];
            L++;
        }

        return L;
    }
}
