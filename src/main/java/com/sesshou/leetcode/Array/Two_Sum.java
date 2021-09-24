package com.sesshou.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wp41128
 * @date 2020/2/25 17:43
 * @description：
 */
public class Two_Sum {
    public static void main(String[] args){
        int[] nums=new int[]{2, 7, 11, 15};
        Two_Sum test=new Two_Sum();
        int[] result=test.twoSumV2(nums,9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        twoSum(nums,9);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key=target-nums[i];
            if(map.get(key)!=null){
                result[0]=map.get(key);
                result[1]=i;
            }else{
                map.put(key,i);
            }
        }

        return result;
    }
    //只能针对已经排好序的  如果自己排序会打乱原来的顺序
    public int[] twoSumV2(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        int len=nums.length;
        if(len<2) return result;
        int left=0;
        int right=len-1;
        while (left<right){
            if(nums[left]+nums[right]==target) break;
            while (left<right&&nums[left]+nums[right]>target)right--;
            while (left<right&&nums[left]+nums[right]>target)left++;
        }
        result[0]=left;
        result[1]=right;
        return result;
    }
}
