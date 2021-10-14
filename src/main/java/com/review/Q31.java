package com.review;

import java.util.Arrays;

//31. Next Permutation
//下一个排列
public class Q31 {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        if(len<2) return;
        int R=len-1;
        while(R>0&&nums[R]<nums[R-1]) R--;
        //这里需要注意下r-1=0的情况下
        //是一个递减数列
        if(R-1>=0){
            int L=len-1;
            while(L>0&&nums[L]<=nums[R-1]) L--;
            int temp=nums[L];
            nums[L]=nums[R-1];
            nums[R-1]=temp;
        }
        Arrays.sort(nums,R,len);
    }
}
