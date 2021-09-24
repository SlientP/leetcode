package com.newStart;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0) return false;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        return true;
    }
    private boolean backfoward(char[][] board,boolean[][] visited,int starti,int startj,String word,int i){
        if(i==word.length()) return true;
        if(word.charAt(i)==board[starti][startj]){
            visited[starti][startj]=true;
            if(starti==0&&startj==0){
                if(!backfoward(board,visited,starti+1,startj,word,i+1)) visited[starti][startj]=false;
                if(!backfoward(board,visited,starti,startj+1,word,i+1)) visited[starti][startj]=false;
            }
        }
        return false;
    }
}
