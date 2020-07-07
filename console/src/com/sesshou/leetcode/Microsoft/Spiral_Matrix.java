package com.sesshou.leetcode.Microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/7/7 8:03
 * @description：螺旋矩阵
 */
public class Spiral_Matrix {
    public static void main(String[] args) {
        Spiral_Matrix test=new Spiral_Matrix();
        int[][] nums=new int[][]{{7},{9},{6}};
        List<Integer> result=test.spiralOrder(nums);
        System.out.println("123");
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return new ArrayList<Integer>();
        int n=matrix[0].length;
        List<Integer> result=new ArrayList<Integer>();
        spriral(matrix,0,m-1,0,n-1,result);
        return result;
    }
    private void spriral(int[][] matrix,int istart,int iend,int jstart,int jend,List<Integer> result){
        if(istart<=iend&&jstart<=jend) {
            int j=istart;
            while (j<=jend) {
                result.add(matrix[istart][j]);
                j++;
            }
            int i=istart+1;
            while (i<=iend){
                result.add(matrix[i][jend]);
                i++;
            }
            j=jend-1;
            while (istart<iend&&j>=jstart){
                result.add(matrix[iend][j]);
                j--;
            }
            i=iend-1;
            while (jstart<jend&&i>istart){
                result.add(matrix[i][jstart]);
                i--;
            }
            spriral(matrix, istart + 1, iend - 1, jstart + 1, jend - 1, result);
        }
    }
}
