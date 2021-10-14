package com.review;

public class Q35 {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return 0;
        int L=0;
        while (L<len&&nums[L]<target)L++;
        return L;
    }
}
