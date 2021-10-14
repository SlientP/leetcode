package com.review;

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
        for (int i = begin; i < nums.length; i++) {
            //跳过的重复的元素 再次走一遍和之前的逻辑
            if(i > begin && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            //i+1 是因为不能重复利用元素
            getTarget(nums,target-nums[i],i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
