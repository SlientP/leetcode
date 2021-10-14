package com.review;

//48. Rotate Image
//旋转图片
//旋转公式
//i,j           -> j,n-i-1;
//j,n-i-1       -> n-i-1,n-j-1
//n-i-1,n-j-1   -> n-j-1,i
//n-j-1,i       -> i,j
//注意赋值的时候需要逆转一下 
public class Q48 {
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        for (int i = 0; i < n/2; i++) {
            //当n为奇数的时候，为了保证不遗漏
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
