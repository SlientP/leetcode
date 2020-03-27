package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/27 10:22
 * @description：
 */
public class Next_Permutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        nextPermutation(nums);
        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return;
        int rannge = len - 1;
        int maxindex = 0;
        int minindex = len - 2;
        while (minindex >= 0) {
            if (nums[minindex] < nums[rannge]) break;
            minindex--;
            rannge--;
        }
        if (rannge != 0) {
            for (int i = len - 1; i >= rannge && i > 0; i--) {
                if (nums[i] > nums[minindex]) {
                    maxindex = i;
                    break;
                }
            }
            int tempindex = nums[minindex];
            nums[minindex] = nums[maxindex];
            nums[maxindex] = tempindex;
        }
        for (int i = rannge; i < rannge + (len - rannge + 1) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - 1 + rannge - i];
            nums[len + rannge - i - 1] = temp;
        }

    }
}
