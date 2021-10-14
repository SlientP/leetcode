package com.review;

import java.util.ArrayList;
import java.util.List;

//78. Subsets --Q90
//不包含重复元素
public class Q78 {
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
            output.remove(output.size()-1);
        }
    }
}
