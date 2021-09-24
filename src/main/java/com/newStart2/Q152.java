package com.newStart2;

public class Q152 {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int[][] dp=new int[len][2];
        dp[0][0]=nums[0];dp[0][1]=nums[0];
        int result=0;
        for (int i = 1; i < len; i++) {
            dp[i][0]=Math.max(Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            dp[i][1]=Math.min(Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            result=Math.max(dp[i][0],result);
        }
        return result;
    }
}
