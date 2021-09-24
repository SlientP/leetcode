package com.newStart2;

public class Q342 {
    public boolean isPowerOfFour(int n) {
        while (n>4&&n%4==0){
            n=n/4;
        }
        return n==1;
    }

    //no loop
    public boolean isPowerOfFourV2(int n) {
        return n>0&&(n&(n-1))==0&&(n&0xaaaaaaaa)==0;
    }
}
