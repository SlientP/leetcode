package com.newStart;

import java.util.*;

public class Q46 {
    public static void main(String[] args) {
        Q46 test=new Q46();
        int[] nums=new int[]{1,2,3};
        test.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
            for (Integer item:output) {
                System.out.print(item);
            }
            System.out.println("");
        }
        //eg:1 2 3
        // 1 | 2 3 -> 1 2 | 3 -> 1 2 3
        // 1 | 2 3 -> 1 3 | 2 -> 1 3 2
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permuteV2(int[] nums) {
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
