package com.review;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len=nums.length;
        List<String> result=new ArrayList<>();
        if(len==0) {
            result.add(getRange(lower, upper));
            return result;
        }
        int j=0;
        while (lower<=upper) {
            if(j>=len) {
                result.add(getRange(lower, upper));break;
            }else if(nums[j]==lower) {
                j++;
                lower++;
            }else {
                result.add(getRange(lower, nums[j]-1));
                lower=nums[j]+1;
                j++;
            }
        }
        return result;
    }
    private String getRange(int low,int upper){
        if(low==upper) return String.valueOf(low);
        else return new String(low+"->"+upper);
    }
}
