package com.sesshou.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/3/31 8:21
 * @description：
 */
public class Combination_Sum {
    public static void main(String[] args) {
        Combination_Sum test=new Combination_Sum();
        int[] nums=new int[]{8,7,4,3};
        Arrays.sort(nums);
        List<List<Integer>> result=test.combinationSum(nums,11);
        System.out.println("123");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) return null;
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        getTarget(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }

    public void getTarget(int[] nums,int target,int  begin,List<List<Integer>> result, List<Integer> temp){
        if(target==0) {
            result.add(new ArrayList<Integer>(temp));
        }
        int len = nums.length;
        for (int i = begin; i < len; i++) {
            int sum = nums[i];
            if (sum > target) {
                break;
            }else {
                temp.add(nums[i]);
                getTarget(nums, target - nums[i], i, result ,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
