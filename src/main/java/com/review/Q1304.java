package com.review;

//1304. Find N Unique Integers Sum up to Zero
public class Q1304 {
    public int[] sumZero(int n) {
        int L=0,R=n-1;
        int[] result=new int[n];
        int f=1;
        while(L<R){
            result[L]-=f;
            result[R]+=f;
            f++;
            L++;
            R--;
        }
        return result;
    }
}
