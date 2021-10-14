package com.review;

//70. Climbing Stairs
public class Q70 {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < n + 1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
