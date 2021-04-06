package com.newStart2;

import java.util.Arrays;

public class Q223 {
    public static void main(String[] args) {
        Q223 test=new Q223();
        System.out.println(test.computeArea(-2,
                        -2,
                2,
                2,
                3,
                3,
                4,
                4));
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] x=new int[4];
        x[0]=A;
        x[1]=C;
        x[2]=E;
        x[3]=G;
        int[] y=new int[4];
        y[0]=B;
        y[1]=D;
        y[2]=F;
        y[3]=H;
        Arrays.sort(x);
        Arrays.sort(y);
        int q1=Math.abs(C-A)*Math.abs(B-D);
        int q2=Math.abs(E-G)*Math.abs(F-H);
        boolean flag=true;
        int qxmin=Math.min(A,C);int pxmin=Math.min(E,G);
        int qxmax=Math.max(A,C);int pxmax=Math.max(E,G);
        int qymin=Math.min(B,D);int pymin=Math.min(F,H);
        int qymax=Math.max(B,D);int pymax=Math.max(F,H);
        if(qxmin>pxmax||qxmax<pxmin||qymin>pymax||qymax<pymin){
            flag=false;
        }
        return flag?q1+q2-(x[2]-x[1])*(y[2]-y[1]):q1+q2;
    }
}
