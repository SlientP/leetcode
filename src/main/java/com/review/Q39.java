package com.review;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> result=new ArrayList<>();
        if(len==0) return result;
        getTarget(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    public void getTarget(int[] nums,int target,int  begin,List<List<Integer>> result, List<Integer> temp) {
        if(target==0){
            result.add(new ArrayList<>(temp));
        }else if(target<0) return;
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            getTarget(nums,target-nums[i],i,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
