package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/3 8:48
 * @description：不同路径2
 */
public class Unique_Paths_II {
    public static void main(String[] args) {
        Unique_Paths_II test=new Unique_Paths_II();
        int[][] a=new int[][]{ {0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(test.uniquePathsWithObstacles(a));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==0){
                    if(i==0&&j==0) dp[0][0]=1;
                    else if(i==0) dp[i][j]=dp[i][j-1];
                    else if(j==0) dp[i][j]=dp[i-1][j];
                    else dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
