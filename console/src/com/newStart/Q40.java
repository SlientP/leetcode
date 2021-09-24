package com.newStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> result=new ArrayList<>();
        if(len==0) return result;
        Arrays.sort(candidates);
        getTarget(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    public void getTarget(int[] nums,int target,int  begin,List<List<Integer>> result, List<Integer> temp) {
        if(target==0){
            result.add(new ArrayList<>(temp));
        }else if(target<0) return;
        while (begin<nums.length&&begin>0&&nums[begin]==nums[begin-1]) begin++;
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            getTarget(nums,target-nums[i],i+1,result,temp);
            temp.remove(new Integer(nums[i]));
        }
    }
}
