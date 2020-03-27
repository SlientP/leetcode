package com.sesshou.leetcode.Array;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/3/25 11:39
 * @description：3个数最近
 */
public class Three_Sum_Closest {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1};
        System.out.println(threeSumClosest(nums,0));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        Arrays.sort(nums);
        int fixed=Integer.MAX_VALUE;
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //下一个元素与上一个元素相同 继续下一次循环
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            int L=i+1;
            int R=len-1;
            while(L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (target == sum) {
                    return target;
                } else if (sum < target) {
//                while(L<R&&nums[L]==nums[L+1])L++;
                    L++;
                } else if (sum > target) {
//                while(L<R&&nums[R]==nums[R-1])R--;
                    R--;
                }
                if (Math.abs(target - sum) < fixed) {
                    fixed = Math.abs(target - sum);
                    result = sum;
                }
            }
        }
        return result;
    }
}
