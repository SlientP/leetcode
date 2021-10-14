package com.review;

//73. Set Matrix Zeroes
//标记其实位置
public class Q73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==0) return;
        boolean isCol=false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0&&matrix[i][j]==0) isCol=true;
                if(matrix[i][j]==0) {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }    
        }
        
        if(isCol){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
