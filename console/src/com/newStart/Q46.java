package com.newStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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



}
