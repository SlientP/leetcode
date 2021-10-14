package com.review;

public class Q75 {
    public void sortColors(int[] nums) {
        int len=nums.length;
        if(len<=1) return;
        int insert_0=0;
        int insert_1=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0){
                swap(nums, i, insert_0);
                if(insert_0<insert_1) swap(nums, i, insert_1);
                insert_0++;insert_1++;
            }else if(nums[i]==1){
                swap(nums, i, insert_1);
                insert_1++;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
