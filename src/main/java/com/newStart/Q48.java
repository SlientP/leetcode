package com.newStart;


//先转置矩阵然后在翻转每一行
public class Q48 {
    //1  2  3  4
    //5  6  7  9
    //9 10 11 12
    //13 14 15 16

    //2(0,1)->2(1,4) 3(0,2)->(2,4)
    //6(1,1)->6(1,3) 10(2,1)->10(1,2);
    //11(2,2)->(2,1)
    //13 9 5 1
    //14 10 6 2
    //15 11 7 3
    //16 12 9 4
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        if(n==0) return;
        boolean[][] isswap=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

    }

    private void swap(int[][] matrix,int i,int j,int n){
        int temp=matrix[i][j];
        if(i==0||j==0){
            matrix[i][j]=matrix[i+j][n-j];
            matrix[i+j][n-j]=temp;
        }
        else{
            matrix[i][j]=matrix[i+j][n-j];
            matrix[i+j][n-j]=temp;
        }
    }
}
