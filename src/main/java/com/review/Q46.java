package com.review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//46. Permutations --- Q47
// 不包含重复数字
public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        if(len==0) return res;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        boolean[] used=new boolean[len];
        dsf(nums,len,0,stack,used,res);
        return res;
    }
    private void dsf(int[] nums, int len, int deep, ArrayDeque stack,boolean[] used,List<List<Integer>> res){
        if(deep==len){
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                stack.addLast(nums[i]);
                used[i]=true;
                dsf(nums,len,deep+1,stack,used,res);
                stack.removeLast();
                used[i]=false;
            }
        }
    }
}
