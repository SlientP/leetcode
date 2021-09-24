package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/2 19:42
 * @description：不同路径
 */
public class Unique_Paths {

    public static void main(String[] args) {
        Unique_Paths test=new Unique_Paths();
        System.out.println(test.uniquePaths(7,3));
    }

    public int uniquePaths(int m, int n) {
        int count=0;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) dp[0][0]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


}
