package com.newStart;

//考虑 x = 0,1,-1;n==0
//
public class Q50 {

    public static void main(String[] args) {

        Q50 test=new Q50();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(test.myPow(2,-2147483648));
    }

    public double myPow(double x, int n) {
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
