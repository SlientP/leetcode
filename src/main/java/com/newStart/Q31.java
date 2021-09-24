package com.newStart;

import java.util.Arrays;

//Next Permutation
public class Q31 {
    public static void main(String[] args) {
        Q31 test=new Q31();
        int[] nums=new int[]{1,1};
        test.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        if(len<2) return;
        int R=len-1;
        while (R-1>=0&&nums[R]<=nums[R-1]) R--;//找到第一个比他小的 所以=号都要包括
        if(R-1>=0){
            int L=len-1;
            while (L>=0&&nums[R-1]>=nums[L]) L--;//找到第一个比他大的 所以=号都要包括
            int temp=nums[R-1];
            nums[R-1]=nums[L];
            nums[L]=temp;
        }
        Arrays.sort(nums,R,len);
    }
}
