package com.review;

//63. Unique Paths II
//有障碍物
public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        if(m==0) return 0;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        //如果起点位置就是障碍物 则无法通过这些路径
        if(obstacleGrid[0][0]==1) return 0;
        dp[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) continue;
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j]=dp[i][j-1];
                }else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
