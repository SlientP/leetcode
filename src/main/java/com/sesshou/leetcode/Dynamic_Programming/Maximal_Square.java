package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/5/8 8:44
 * @description： 最大正方形
 */
public class Maximal_Square {
    public static void main(String[] args) {
        Maximal_Square test = new Maximal_Square();
        char[][] nums = new char[][]{};
        System.out.println(test.maximalSquare(nums));
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = matrix[i][j] - 48;
                } else if (matrix[i][j] == '0') {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
                res = f[i][j] > res ? f[i][j] : res;
            }
        }
        return res * res;
    }
}
