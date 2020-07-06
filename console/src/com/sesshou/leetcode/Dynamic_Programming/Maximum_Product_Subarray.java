package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/7/2 11:39
 * @description：乘积最大字数组
 */
public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len][len];
        for (int i = 0; i < len ; i++) {
            for (int j = i; j > 0 ; j--) {
                if(i==j) dp[i][j]=nums[i];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1] * nums[j], 0);
                }
            }
        }
        return dp[0][len-1];
    }
}
