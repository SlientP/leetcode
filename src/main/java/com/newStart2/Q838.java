package com.newStart2;

public class Q838 {
    public int projectionArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int xy=0;
        for(int i=0;i<n;i++){
            int yheight=0;int zheight=0;
            for(int j=0;j<m;j++){
                xy+=grid[i][j]>0?1:0;
                yheight=Math.max(yheight, grid[i][j]);
                zheight=Math.max(zheight,grid[j][i]);
            }
            xy+=yheight;
            xy+=zheight;
        }
        return xy;
    }
}
