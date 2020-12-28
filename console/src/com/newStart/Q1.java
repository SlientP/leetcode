package com.newStart;

import java.util.HashMap;
//题目中数组是无序的 如果是排序的话可以使用双指针的方式来操作
//如果使用排序 排序都会消耗nlogn的时间
public class Q1 {
    public static void main(String[] args) {
        Q1 test=new Q1();
        int[] nums=new int[]{2, 7, 11, 15};
        int[] result=test.twoSum(nums,9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        int len=nums.length;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        if(len>1){
            for (int i = 0; i < len; i++) {
                if(map.isEmpty()||!map.keySet().contains(nums[i])){
                    map.put(target- nums[i],i);
                }else{
                    result[0]=map.get(nums[i]);
                    result[1]=i;
                    break;
                }
            }
        }
        return result;
    }
}
