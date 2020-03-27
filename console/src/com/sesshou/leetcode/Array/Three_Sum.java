package com.sesshou.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/3/25 9:22
 * @description：3数和
 */
public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //大于0去除
            if (nums[i] > 0) break;
            //下一个元素与上一个元素相同 继续下一次循环
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            //左右双指针
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    //满足条件
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //去除重复字段
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return result;
    }
}
