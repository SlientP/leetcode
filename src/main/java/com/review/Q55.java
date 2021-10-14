package com.review;

//55. Jump Game --- Q45
//能不能调到最后一位
public class Q55 {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        int max=nums[0];
        int i=0;
        while(i<=max&&i<len){
            max=Math.max(i+nums[i],max);
            i++;
        }
        //max >= len-1
        //能不能跳到最后一位去
        return max>=len-1;
    }
}
