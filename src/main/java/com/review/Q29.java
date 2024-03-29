package com.review;

//29. Divide Two Integers
// 需要重点关注下
public class Q29 {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        if(divisor==-1) {
            if(dividend<=Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }
        long a=dividend;
        long b=divisor;
        int sign=1;
        if((a>0&&b<0)||(a<0&&b>0)){
            sign=-1;
        }
        a=a>0?a:-a;
        b=b>0?b:-b;
        int res=div(a,b);
        return res*sign;
    }
    private int div(long a,long b){
        if(a<b) return 0;
        int count=1;
        long tb=b;
        while((tb+tb)<=a){
            count+=count;
            tb=tb+tb;
        }
        return count+div(a-tb,b);
    }
}
