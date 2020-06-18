package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/17 10:54
 * @description：不同的子序列
 */
public class Distinct_Subsequences {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        //初始化第一行
        for(int j = 0; j <= s.length(); j++){
            dp[0][j] = 1;
        }
        //dp[i-1][j-1]就是当前最后一位匹配
        //dp[i][j-1] 之前匹配上的去掉最后一位在匹配上现在的
        for(int i = 1; i <= t.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
