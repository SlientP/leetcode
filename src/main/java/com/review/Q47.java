package com.review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//47. Permutations II --- Q46
//非常重要 需要多去思考下
//包含重复数字
public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            //关键代码去除重复的元素
            //如果i>0并且i和i-1 都没有使用过 然后还相等
            //因为i-1的逻辑已经走过一遍了 所以此时i 并不用再走一次
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
    
            stack.addLast(nums[i]);
            used[i]=true;
            dsf(nums,len,deep+1,stack,used,res);
            stack.removeLast();
            used[i]=false;
            
        }
    }
}
