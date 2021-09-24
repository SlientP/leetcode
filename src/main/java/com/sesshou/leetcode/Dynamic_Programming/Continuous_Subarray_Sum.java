package com.sesshou.leetcode.Dynamic_Programming;

import java.util.HashMap;

/**
 * @author wp41128
 * @date 2020/5/6 19:29
 * @description：
 */
public class Continuous_Subarray_Sum {

    public static void main(String[] args) {
        Continuous_Subarray_Sum  test=new Continuous_Subarray_Sum();
        int[] nums=new int[]{23, 2, 4, 6, 7};

        System.out.println(test.checkSubarraySumV2(nums,6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int len=nums.length;
        for (int i = 0; i < len-1; i++) {
            int sum=nums[i];
            for (int j = i+1; j < len ; j++) {
                sum+=nums[j];
                if(k==0&&sum==0) return true;
                else if(k!=0&&sum%k==0) return true;
            }
        }
        return false;
    }
    //假设第 i 个位置的 sum%ksum 的值为 remrem 。
    // 如果以 i 为左端点的任何子数组的和是 kk 的倍数，比方说这个位置为 j ，
    // 那么 HashMap 中第 j个元素保存的值为 (rem + n*k)\%k(rem+n∗k)%k ，其中 nn 是某个大于 0 的整数。
    // 我们会发现 (rem + n*k)\%k = rem(rem+n∗k)%k=rem ，也就是跟第 i 个元素保存到 HashMap 中的值相同。
    public boolean checkSubarraySumV2(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer,Integer> map = new HashMap<Integer, Integer>();
        //保证i可以从初始位置开始
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
