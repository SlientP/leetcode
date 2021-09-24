package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public static void main(String[] args) {
        Q54 test=new Q54();
        int[][] m=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        test.spiralOrder(m);
    }
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
            while (j>=L&&j<=R&&i>=T&&i<=B){
                res.add(matrix[i][j]);
                i++;
            }
            i--;R--;j--;
            while (j>=L&&j<=R&&i>=T&&i<=B) {
                res.add(matrix[i][j]);
                j--;
            }
            B--;j++;i--;
            while (j>=L&&j<=R&&i>=T&&i<=B){
                res.add(matrix[i][j]);
                i--;
            }
            L++;i++;j++;
        }
        return res;
    }
}
