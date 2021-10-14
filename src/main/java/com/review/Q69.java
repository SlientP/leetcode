package com.review;

//69. Sqrt(x)
public class Q69 {
    public int mySqrt(int x) {
        int l=0; 
        int r=x;
        int result=-1;
        while(l<=r){
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
