package com.review;

//79. Word Search
public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        //为了保证不能走回头路
        boolean[][] visited=new boolean[m][n];
        boolean result=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==word.charAt(0)){
                    visited[i][j]=true;
                    result =result||find(board,visited, i-1, j, word, 1, m, n)||find(board,visited, i+1, j, word, 1, m, n)
                ||find(board,visited, i, j-1, word, 1, m, n)||find(board,visited, i, j+1, word, 1, m, n);
                    //这里是为了已经走过的路程如果不行 那么走过的元素都要标记为未走过
                    if(!result) visited[i][j]=false;
                }
            }
        }
        return result;
    }
    private boolean find(char[][] board,boolean[][] visited,int i,int j,String word,int index,int m,int n){
        if(index==word.length()) return true;
        boolean result=false;
        if(i<m&&j<n&&i>=0&&j>=0){
            if(board[i][j]==word.charAt(index)&&!visited[i][j]){
                visited[i][j]=true;
                result = result|| find(board,visited, i-1, j, word, index+1, m, n)||find(board,visited, i+1, j, word, index+1, m, n)
                ||find(board,visited, i, j-1, word, index+1, m, n)||find(board,visited, i, j+1, word, index+1, m, n);
                if(!result) visited[i][j]=false;
            }
        }
        return result;
    }
}
