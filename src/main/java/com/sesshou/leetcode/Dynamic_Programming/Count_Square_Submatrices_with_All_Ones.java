package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/5/7 8:49
 * @description：统计全为 1 的正方形子矩阵
 */
public class Count_Square_Submatrices_with_All_Ones {
    public static void main(String[] args) {
        Count_Square_Submatrices_with_All_Ones test = new Count_Square_Submatrices_with_All_Ones();
        int[][] nums = new int[][]{{0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        System.out.println(test.countSquares(nums));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    f[i][j]=matrix[i][j];
                }else if (matrix[i][j] == 0) {
                    f[i][j]=0;
                }else{
                    f[i][j]=Math.min(f[i-1][j],Math.min(f[i][j-1],f[i-1][j-1]))+1;
                }
                count+=f[i][j];
            }
        }
        return count;
    }
}
