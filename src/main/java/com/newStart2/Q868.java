package com.newStart2;

public class Q868 {
    public int binaryGap(int n) {
        int lastindex=-1;
        int res=0;
        for(int i=0;n!=0;i++){
            if((n&1)==1){
                if(lastindex!=-1){
                    res=Math.max(res, i-lastindex);
                }
                lastindex=i;
            }
            n=n>>1;
        }
        return res;
    }
}
