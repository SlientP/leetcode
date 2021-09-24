package com.newStart2;

public class Q191 {
    public int hammingWeight(int n) {
        int res=0;
        while (n>0){
            res++;
            n&=n-1;
        }
        return res;
    }
}
