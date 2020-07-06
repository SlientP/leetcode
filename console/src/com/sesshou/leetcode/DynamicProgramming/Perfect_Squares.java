package com.sesshou.leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2020/4/19 0019.
 */
public class Perfect_Squares {
    public static void main(String[] args) {
        Perfect_Squares test=new Perfect_Squares();
        System.out.println(test.numSquares(12));
    }

    //动态规划 自底向上
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        int max=(int)Math.sqrt(n)+1;
        int[] sqrtNums=new int[max];
        for (int i = 1; i < max; i++) {
            sqrtNums[i]=i*i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < max; j++) {
                if(i<sqrtNums[j]) break;
                dp[i]=Math.min(dp[i],dp[i-sqrtNums[j]]+1);
            }
        }
        return dp[n];
    }

    //贪心算法 用最少的次数划分一个数字
    Set<Integer> square_nums = new HashSet<Integer>();
    protected boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }

        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }
    public int numSquaresV2(int n) {
        this.square_nums.clear();

        for (int i = 1; i * i <= n; ++i) {
            this.square_nums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count))
                return count;
        }
        return count;
    }


}
