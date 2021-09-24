package com.sesshou.leetcode.Dynamic_Programming;

import java.util.List;

/**
 * @author wp41128
 * @date 2020/6/17 14:20
 * @description：三角形最小路径和
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
//        // dp中记录了求第i行时，第i+1的最小路径和
//        int[] dp = new int[triangle.size() + 1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> rows = triangle.get(i);
//            for (int j = 0; j < rows.size(); j++) {
//                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
//            }
//        }
//        return dp[0];


        int row=triangle.size();
        int col=triangle.get(row-1).size();
        int[][] dp=new int[row+1][col+1];
        for (int i = row-1; i >=0 ; i--) {
            List<Integer> rows=triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+rows.get(j);
            }
        }
        return dp[0][0];
    }
}
