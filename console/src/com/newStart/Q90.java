package com.newStart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q90 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,2};
        Q90 test=new Q90();
        List<List<Integer>> res=test.subsetsWithDup(nums);
        System.out.println(1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        List<String> maps=new ArrayList<>();
        backforward(output,0,nums,res);
        return res;
    }

    private void backforward(List<Integer> output,int first,int[] nums,List<List<Integer>> res){
        res.add(new ArrayList<>(output));
        for (int i = first; i < nums.length; i++) {
            if(i>first&&nums[i]==nums[i-1]){
                continue;
            }
            output.add(nums[i]);
            backforward(output, i + 1, nums, res);
            output.remove(new Integer(nums[i]));
        }

    }
}
