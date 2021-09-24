package com.newStart2;

import java.util.HashSet;

public class Q202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        if(n!=1&&!set.contains(n)){
            set.add(n);
            n=getNext(n);
        }
        return n==1;
    }

    private int getNext(int n){
        int res=0;
        while (n>0){
            int a=n%10;
            res+=a*a;
            n=n/10;
        }
        return res;
    }
}
