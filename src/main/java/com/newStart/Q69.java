package com.newStart;

public class Q69 {
    public static void main(String[] args) {
        Q69 test=new Q69();
        System.out.println(test.mySqrt(0));
    }
    public int mySqrt(int x) {
        int l=0, r=x,result=-1;
        while (l<r){
            int mid=(l+r)/2;
            if((long)mid*mid<=x){
                result=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return result;
    }
}
