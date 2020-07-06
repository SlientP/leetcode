package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/30 17:11
 * @description：甲板上的战舰
 */
public class Battleships_in_a_Board {
    public static void main(String[] args) {
        Battleships_in_a_Board test=new Battleships_in_a_Board();
        char[][] borad=new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(test.countBattleshipsV2(borad));
    }
    //change value
    public int countBattleships(char[][] board) {
        int m=board.length;
        if(m==0) return 0;
        int n=board[0].length;
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='X'){
                    count++;
                    checkShip(board,i-1,j,m,n);
                    checkShip(board,i,j-1,m,n);
                    checkShip(board,i+1,j,m,n);
                    checkShip(board,i,j+1,m,n);
                }
            }
        }
        return count;
    }
    private void checkShip(char[][] board,int i,int j,int m,int n){
       if(i<m&&j<n&&i>=0&&j>=0){
           if(board[i][j]=='X'){
               board[i][j]='.';
               checkShip(board,i-1,j,m,n);
               checkShip(board,i,j-1,m,n);
               checkShip(board,i+1,j,m,n);
               checkShip(board,i,j+1,m,n);
           }
       }
    }
    //without changing value
    public int countBattleshipsV2(char[][] board) {
        int m=board.length;
        if(m==0) return 0;
        int n=board[0].length;
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='.') continue;
                if(i>0&&board[i-1][j]=='X') continue;
                if(j>0&&board[i][j-1]=='X') continue;
                count++;
            }
        }
        return count;
    }
}
