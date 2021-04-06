package com.newStart2;

public class Q169 {

    public int majorityElement(int[] nums) {
        int len= nums.length;
        if(len==0) return 0;
        int temp=nums[0];
        int count=1;
        for (int i = 1; i < len; i++) {
            if(temp==nums[i])count++;
            else count--;
            if(count==0) {
                temp = nums[++i];
                count=1;
            }
        }
        return temp;
    }
}
