package com.review;

import java.util.ArrayList;
import java.util.List;

//54. Spiral Matrix ---Q59
//定义上下左右4个边界
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;
        int T=0;int B=m-1;int L=0;int R=n-1;
        int i=0,j=0;
        while (res.size()<m*n){
            while (j>=L&&j<=R&&i>=T&&i<=B) {
                res.add(matrix[i][j]);
                j++;
            }
            j--;T++;i++;
            while (j>=L&&j<=R&&i>=T&&i<=B) {
                res.add(matrix[i][j]);
                i++;
            }
            i--;R--;j--;
            while (j>=L&&j<=R&&i>=T&&i<=B) {
                res.add(matrix[i][j]);
                j--;
            }
            B--;j++;i--;
            while (j>=L&&j<=R&&i>=T&&i<=B) {
                res.add(matrix[i][j]);
                i--;
            }
            L++;i++;j++;
        }
        return res;
    }
}
