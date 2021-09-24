package com.newStart2;

public class Q286 {
    public static void main(String[] args) {
        int[][] rooms=new int[][]{{2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}};
        Q286 test=new Q286();
        test.wallsAndGates(rooms);
    }
    public void wallsAndGates(int[][] rooms) {
        int m=rooms.length;
        if(m==0) return;
        int n=rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rooms[i][j]==0){
                    dfs(rooms,i-1,j,1);
                    dfs(rooms,i+1,j,1);
                    dfs(rooms,i,j-1,1);
                    dfs(rooms,i,j+1,1);
                }
            }
        }
    }

    private void dfs(int[][] rooms,int i,int j,int step) {
        int m=rooms.length;
        int n=rooms[0].length;
        if(i>=0&&i<m&&j>=0&&j<n&&rooms[i][j]!=-1&&rooms[i][j]!=0){
            rooms[i][j]=Math.min(rooms[i][j],step);
            dfs(rooms,i-1,j,step+1);
            dfs(rooms,i+1,j,step+1);
            dfs(rooms,i,j-1,step+1);
            dfs(rooms,i,j+1,step+1);
        }
    }
}
