package com.microsoftInterview;

public class Q3 {

    public static void main(String[] args) {
        Q3 test=new Q3();
    }
    public int maxWidthRamp(int[] nums) {
        int len=nums.length;
        int L=0;int R=len-1;
        int result=0;
        while(nums[L]>nums[R])L++;
        result=Math.max(result,R-L);
        while(L>0){
            if(nums[L-1]<=nums[R-1]){
                L--;R--;
                while(L>0&&nums[L-1]<=nums[R]) L--;
                result=Math.max(result,R-L);
            }
        }
        return result;
    }
}
