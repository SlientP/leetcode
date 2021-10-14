package com.review;

//26. Remove Duplicates from Sorted Array --Q80
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<2) return len;
        int slow=1;
        int fast=1;
        while (fast<len){
            while (fast<len&&nums[fast]==nums[fast-1]) fast++;
            //如果fast指针已经到达最末端就不需要进行交换
            if(fast<len){
                nums[slow]=nums[fast];
                slow++;fast++;
            }
        }
        return slow;
    }
}
