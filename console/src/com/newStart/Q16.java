package com.newStart;

import java.util.Arrays;

//3Sum Closest
public class Q16 {
    public static void main(String[] args) {
        Q16 test=new Q16();
        int[] nums=new int[]{-1,2,1,-4};
        System.out.println(test.threeSumClosest(nums,1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int res_sum=0;
        Arrays.sort(nums);
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < len ; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int k=len-1;
                while (k>j){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(Math.abs(target-sum)<Math.abs(target-res_sum)){
                        res_sum=sum;
                    }
                    k--;
                }
            }
        }
        return res_sum;
    }
}
