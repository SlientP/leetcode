package com.sesshou.leetcode.Array;

import java.util.HashMap;

/**
 * @author wp41128
 * @date 2020/2/25 17:43
 * @description：
 */
public class Two_Sum {
    public static void main(String[] args){
        int[] nums=new int[]{2,7,11,15};
        twoSum(nums,9);
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key=target-nums[i];
            if(map.get(nums[i])!=null){
                result[0]=map.get(nums[i]);
                result[1]=i;
            }else{
                map.put(nums[i],i);
            }
        }

        return result;
    }
}
