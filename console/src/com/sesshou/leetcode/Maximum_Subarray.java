package com.sesshou.leetcode;

/**
 * Created by Administrator on 2020/3/15 0015.
 */
public class Maximum_Subarray {
    public static void main(String[] args) {
        Maximum_Subarray test=new Maximum_Subarray();
        int[] nums=new int[]{-2,-1};
        test.bothSize(nums,0,nums.length-1);
    }

    //分治
    public int bothSize(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int p = (left + right) / 2;
        int leftSum = bothSize(nums, left, p);
        int rightSum = bothSize(nums, p+1, right);
        int middleSum = middle(nums, left, right, p);
        return Math.max(Math.max(rightSum, leftSum), middleSum);
    }

    public int middle(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];
        int leftMaxSum = Integer.MIN_VALUE;
        int leftcur = 0;
        for (int i = p; i >= left; i--) {
            leftcur += nums[i];
            leftMaxSum = Math.max(leftcur, leftMaxSum);
        }

        int rightMaxSum = Integer.MIN_VALUE;
        int rightcur = 0;
        for (int i = p + 1; i <= right; i++) {
            rightcur += nums[i];
            rightMaxSum = Math.max(rightcur, rightMaxSum);
        }
        return leftMaxSum + rightMaxSum;
    }

    //贪心
    public int mymaxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < n; i++) {
            cur = Math.max(cur, cur + nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
