package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/3 9:17
 * @description：爬楼梯
 */
public class Climbing_Stairs {

    public static void main(String[] args) {
        Climbing_Stairs test=new Climbing_Stairs();
        System.out.println(test.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for (int i = 1; i < n+1 ; i++) {
            if(i==1) dp[i]=1;
            else if(i==2) dp[i]=2;
            else dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
//        if(n==1) return 1;
//        if(n==2) return 2;
//        else return climbStairs(n-1)+climbStairs(n-2);
    }
}
