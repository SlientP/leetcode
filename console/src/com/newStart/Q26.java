package com.newStart;

//Remove Duplicates from Sorted Array
public class Q26 {
    public static void main(String[] args) {
        Q26 test=new Q26();
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(test.removeDuplicates(nums));
        System.out.println(123);
    }
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<2) return len;
        int slow=1;
        int fast=1;
        while (fast<len){
            while (fast<len&&nums[fast]==nums[fast-1]) fast++;
            if(fast<len){
                nums[slow]=nums[fast];
                slow++;fast++;
            }
        }
        return slow;
    }
}
