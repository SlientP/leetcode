package com.review;

//50. Pow(x, n)
//需要考虑负指数的情况
public class Q50 {
    public double myPow(double x, int n) {
        if(n==0) return 1L;
        if(n==Integer.MIN_VALUE) return myPow(x, n+1)/x;
        double temp=myPow(x, Math.abs(n)/2);
        temp=n%2==0?temp*temp:x*temp*temp;
        return n>0?temp:1/temp;
    }
    public double myPowV2(double x, int n) {
        
        //2 -2的32次方 Math.abs(n)/2便会溢出
        long N=n; //int 最大值会溢出 2的32次方
        return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    private double quickPow(double x,long n){
        if(n==0) {
            return 1L;
        }
        double y=quickPow(x,n/2);
        return n%2==0?y*y:y*y*x;
    }
}
