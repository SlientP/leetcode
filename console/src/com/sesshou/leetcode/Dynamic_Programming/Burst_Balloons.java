package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/18 9:03
 * @description：戳气球
 */
public class Burst_Balloons {
    public static void main(String[] args) {
        Burst_Balloons test=new Burst_Balloons();
        int[] nums=new int[]{3,1,5,8};
        System.out.println(test.maxCoins(nums));
    }
    public int maxCoins(int[] nums) {

        // reframe the problem
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for(int i = 0; i < nums.length; i++){
            new_nums[i+1] = nums[i];
        }

        new_nums[0] = new_nums[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        // find the maximum number of coins obtained from adding all balloons from (0, len(nums) - 1)
        return dp(memo, new_nums, 0, n - 1);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        //
        if (left + 1 == right) return 0;

        // 已经计算过了
        if (memo[left][right] > 0) return memo[left][right];

        // add each balloon on the interval and return the maximum score
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + dp(memo, nums, left, i) + dp(memo, nums, i, right));
        // 缓存结果
        memo[left][right] = ans;
        return ans;
    }
}
