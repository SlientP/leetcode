package com.newStart2;

public class Q162 {
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if(len==1) return 0;
        int R=0;
        while (R + 1 < len && nums[R] < nums[R + 1]) R++;
        return R;
    }
    public int findPeakElementV2(int[] nums) {
        return search(nums,0, nums.length-1);
    }
    private int search(int[] nums,int L,int R){
        if(L==R) return L;
        int mid=(L+R)/2;
        if(nums[mid]>nums[mid+1])
            return search(nums,L,mid);
        else return search(nums,mid+1,R);
    }
}
