package com.sesshou.leetcode.Array;

/**
 * @author wp41128
 * @date 2020/3/30 16:45
 * @description：最早和最晚元素
 */
public class First_and_Last_Position_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=8;
        First_and_Last_Position_in_Sorted_Array test=new First_and_Last_Position_in_Sorted_Array();
        int[] result=test.searchRange(nums,6);
        System.out.println("12");
    }
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return new int[]{-1,-1};
        if(len==1) return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
        int firstIndex=findIndex(nums,0,len-1,target);
        int minIndex=firstIndex;
        int maxIndex=firstIndex;
        if(firstIndex!=-1){
            while (minIndex>0&&nums[minIndex]==nums[minIndex-1]) minIndex--;
            while (maxIndex<len-1&&nums[maxIndex]==nums[maxIndex+1]) maxIndex++;
        }
        return new int[]{minIndex,maxIndex};
    }

    public int findIndex(int[] nums,int left,int right,int target){
        while (left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]){
                left=mid+1;
            }else right=mid-1;
        }
        return -1;
    }
}
