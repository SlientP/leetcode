package com.review;

//53. Maximum Subarray
public class Q53 {

    public static void main(String[] args){
        Q53 test=new Q53();
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        test.maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int result=nums[0];
        int temp=nums[0];
        for (int i = 1; i < len; i++) {
            temp=Math.max(temp+nums[i],nums[i]);
            result=Math.max(result,temp);
        }
        return result;
    }
}
