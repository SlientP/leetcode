package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/17 18:38
 * @description：
 */
public class House_Robber {
    public static void main(String[] args) {
        House_Robber test=new House_Robber();
        int[] nums=new int[]{2,1,1,2};
        System.out.println(test.rob(nums));
    }
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int[] dp=new int[len];
        for (int i = 0; i < len ; i++) {
            if(i==0) dp[i]=nums[i];
            else if(i==1) dp[i]=Math.max(nums[0],nums[1]);
            else dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
}
