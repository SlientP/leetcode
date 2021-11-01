package com.review;

//1822. Sign of the Product of an Array
public class Q1822 {
    public int arraySign(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(nums[0]==0) return 0;
        boolean flag=nums[0]>0?true:false;
        for (int i = 1; i < len; i++) {
            if(nums[i]==0) return 0;
            else if(nums[i]<0) flag=!flag; 
        }
        return flag?1:-1;
    }
}
