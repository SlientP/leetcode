package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    public static void main(String[] args) {
        Q78 test=new Q78();
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> res= test.subsets(nums);
        System.out.println(1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();

        backtrack(nums, output, res, 0);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        res.add(new ArrayList<Integer>(output));
        for (int i = first; i < nums.length ; i++) {
            // 动态维护数组
            output.add(nums[i]);
            // 继续递归填下一个数
            backtrack(nums, output, res, i+1);
            // 撤销操作
            output.remove(new Integer(nums[i]));
        }
    }
}

