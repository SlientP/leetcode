package com.newStart;

//Surrounded Regions
//此处采用的思路是 与边缘O相连的才不会被X包围
//所以从边缘处的O开始遍历数组 打上标记
//打上标记的即为不被包围的
public class Q130 {
    public static void main(String[] args) {
        Q130 test=new Q130();
        char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','O'},{'X','O','X','X'}};
        test.solve(board);
        int m= board.length;
        int n= board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public void solve(char[][] board) {
        int n= board.length;
        if(n==0) return;
        int m= board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board,i,0,m,n);
            dfs(board,i,m-1,m,n);
        }
        for (int j = 1; j < m-1; j++) {
            dfs(board,0,j,m,n);
            dfs(board,n-1,j,m,n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j,int m,int n){
        if(i<0||i>=n||j<0||j>=m||board[i][j]!='O') return;//如果此处是=='X'
        // 会导致之前复制过A的也继续重复判断，所以此处是!='O'
        board[i][j]='A';
        dfs(board, i + 1, j,m,n);
        dfs(board, i - 1, j,m,n);
        dfs(board, i, j + 1,m,n);
        dfs(board, i, j - 1,m,n);
    }

}
