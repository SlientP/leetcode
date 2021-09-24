package com.sesshou.leetcode.DynamicProgramming;

/**
 * Created by Administrator on 2020/4/19 0019.
 */
public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        Longest_Increasing_Subsequence test=new Longest_Increasing_Subsequence();
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(test.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        for (int i = 1; i < len ; i++) {
            if(nums[i]<nums[i-1]) dp[i]=dp[i-1];
            dp[i]=Math.max(dp[i-1]+1,dp[i]);
        }
        return dp[len-1];
    }

}
