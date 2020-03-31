package com.sesshou.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/3/31 15:48
 * @description：
 */
public class Combination_Sum2 {
    public static void main(String[] args) {
        Combination_Sum2 test = new Combination_Sum2();
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(nums);
        List<List<Integer>> result = test.combinationSum2(nums, 8);
        System.out.println("123");
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getTarget(candidates, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void getTarget(int[] nums, int target, int begin, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
        }
        int len = nums.length;
        for (int i = begin; i < len; i++) {
            int sum = nums[i];
            if (sum > target) {
                break;
            }
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            } else {
                temp.add(nums[i]);
                getTarget(nums, target - nums[i], i + 1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
