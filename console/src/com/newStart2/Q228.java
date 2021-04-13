package com.newStart2;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        int len=nums.length;
        List<String> res=new ArrayList<>();
        if(len==0) return res;
        int L=0;
        int R=0;
        for (int i = 1; i < len; i++) {
            if(nums[i]==++nums[R]) R++;
            else{
                if(L==R) res.add(nums[R]+"");
                else res.add(nums[L]+"->"+nums[R]);
                L=R=i;
            }
        }
        return res;
    }
}
