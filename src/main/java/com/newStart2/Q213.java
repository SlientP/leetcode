package com.newStart2;

import java.util.Arrays;

public class Q213 {
    public static void main(String[] args) {
        Q213  test=new Q213();
        int[] nums=new int[]{1};
        System.out.println(test.rob(nums));
    }
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
       return Math.max(robV1(Arrays.copyOfRange(nums,1,nums.length)),robV1(Arrays.copyOf(nums,nums.length-1)));
    }

    public int robV1(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int[][] dp=new int[len][2];
        dp[0][1]=nums[0];
        dp[0][0]=0;
        for (int i = 1; i < len; i++) {
            dp[i][1]=dp[i-1][0]+nums[i];
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
