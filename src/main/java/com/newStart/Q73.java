package com.newStart;

import java.util.ArrayList;
import java.util.List;

//遍历一遍标记行列要转为0的
public class Q73 {
    //use m+n space
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return;
        List<Integer> lines=new ArrayList<>();
        List<Integer> rows=new ArrayList<>();
        int n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0) {
                    lines.add(i);rows.add(j);
                }
            }
        }
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[lines.get(i)][j]=0;
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][rows.get(i)]=0;
            }
        }
    }

    public void setZeroesV2(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return;
        boolean isCol=false;
        int n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //isCol表示这一列是否为0
                if(j==0&&matrix[i][j]==0) isCol=true;
                else if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
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
