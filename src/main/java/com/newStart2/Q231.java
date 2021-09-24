package com.newStart2;

public class Q231 {
    public boolean isPowerOfTwo(int n) {
        int i=1;
        while (n>0&&n/2==0){
            n=n/2;
        }
        return n==1;
    }
}
