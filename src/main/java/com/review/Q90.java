package com.review;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//90. Subsets II
//包含重复元素
public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        Arrays.sort(nums);
        backforward(output,0,nums,res);
        return res;
    }

    private void backforward(List<Integer> output,int first,int[] nums,List<List<Integer>> res){
        res.add(new ArrayList<>(output));
        for (int i = first; i < nums.length; i++) {
            //key word to remove duplicate element
            //i>first 保证first第一次可以加进去
            if(i>first&&nums[i]==nums[i-1]){
                continue;
            }
            output.add(nums[i]);
            backforward(output, i + 1, nums, res);
            output.remove(output.size()-1);
        }

    }
}
