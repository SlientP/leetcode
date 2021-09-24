package com.newStart2;

public class Q200 {
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length;
        if(m==0) return count;
        int n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    BFS(grid,i-1,j,m,n);
                    BFS(grid,i,j-1,m,n);
                    BFS(grid,i+1,j,m,n);
                    BFS(grid,i,j+1,m,n);
                }
            }
        }
        return count;
    }
    private void BFS(char[][] grid,int i,int j,int m,int n){
        if(i>=0&&i<m&&j>=0&&j<n){
            if(grid[i][j]=='1'){
                grid[i][j]='0';
                BFS(grid,i-1,j,m,n);
                BFS(grid,i,j-1,m,n);
                BFS(grid,i+1,j,m,n);
                BFS(grid,i,j+1,m,n);
            }
        }
    }
}
