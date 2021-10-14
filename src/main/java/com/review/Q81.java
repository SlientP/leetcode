package com.review;

//81. Search in Rotated Sorted Array II ---Q33
//返回是否存在
//有重复的元素
public class Q81 {
    public boolean search(int[] nums, int target) {
        int len=nums.length;
        int L=0;
        int R=len-1;
        while(L<=R){
            while(L<R&&nums[L]==nums[L+1]) L++;
            while(R>L&&nums[R]==nums[R-1]) R--;
            int mid=(L+R)/2;
            if(nums[mid]==target) return true;
            //0到mid递增
             //当nums[0]和nums[mid]重合时
            //【3,1】 1
            if(nums[0]<=nums[mid]){
                if(target<nums[mid]&&target>=nums[0]) R=mid-1;
                else L=mid+1;
            }else{//mid到len 递增
                if(target>nums[mid]&&target<=nums[R]) L=mid+1;
                else R=mid-1;
            }
        }
        return false;
    }
}
