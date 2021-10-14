package com.review;

//34. Find First and Last Position of Element in Sorted Array
public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        //没有考虑到的情况
        if(len==0) return new int[]{-1,-1};
        int L=0;int R=len-1;
        int mid=(L+R)/2;
        while(L<=R){
            mid=(L+R)/2;
            if(nums[mid]==target) break;
            if(target>nums[mid]) L=mid+1;
            else R=mid-1;
        }
        if(nums[mid]==target){
            int l=mid;int r=mid;
            while(l>=0&&nums[l]==target) l--;
            while(r<len&&nums[r]==target) r++;
            return new int[]{l+1,r-1};
        }
        return new int[]{-1,-1};
    }
}
