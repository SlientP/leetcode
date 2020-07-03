package com.sesshou.leetcode.Dynamic_Programming;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/6/3 8:55
 * @description：最小路径和
 */
public class Minimum_Path_Sum {

    public static void main(String[] args) {
        Minimum_Path_Sum test=new Minimum_Path_Sum();
        int[][] a=new int[][]{{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(test.minPathSum(a));
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) continue;
                else if(i==0) grid[i][j]=grid[i][j-1]+grid[i][j];
                else if(j==0) grid[i][j]=grid[i-1][j]+grid[i][j];
                else grid[i][j]=Math.min(grid[i][j-1]+grid[i][j],grid[i-1][j]+grid[i][j]);
             }
        }
        return grid[m-1][n-1];
    }
}
