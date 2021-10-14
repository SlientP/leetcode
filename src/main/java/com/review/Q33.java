package com.review;

//33. Search in Rotated Sorted Array ---Q81
//返回查找的位置
//时间复杂度要达到O（lgN）
//要与nums[0]做对比 
public class Q33 {
    public static void main(String[] args){
        int[] nums=new int[]{1,3,5};
        Q33 test=new Q33();
        test.search(nums, 1);
    }
    public int search(int[] nums, int target) {
        int len=nums.length;
        int L=0;
        int R=len-1;
        while(L<=R){
            int mid=(L+R)/2;
            if(nums[mid]==target) return mid;
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
        return -1;
    }
}
