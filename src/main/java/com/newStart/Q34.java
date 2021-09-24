package com.newStart;

//Find First and Last Position of Element in Sorted Array
public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return new int[]{-1,-1};
        int L=0;
        int R=len-1;
        while (L<R&&nums[L]<target) L++;
        while (R>L&&nums[R]>target) R--;
        return new int[]{nums[L]==target?L:-1,nums[R]==target?R:-1};
    }
}
