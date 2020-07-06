package com.sesshou.leetcode;

/**
 * @author wp41128
 * @date 2020/2/28 11:43
 * @description：
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Longest_Palindromic_Substring test=new Longest_Palindromic_Substring();
        System.out.println(test.longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) return s;
        boolean[][] dp = new boolean[len+1][len+1];
        String result = "";
        for (int j = 0; j < len + 1; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j||i+1==j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j-1) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && result.length() < j - i ) result = s.substring(i, j );
            }
        }
        return result;
    }
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        boolean[][] p = new boolean[n + 1][n + 1];
        String max="";
        for (int j = 0; j < n + 1; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j || i + 1 == j) {
                    p[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j-1) && p[i + 1][j - 1]) {
                    p[i][j] = true;
                }
                if (p[i][j] && max.length() < j - i) max = s.substring(i, j);
            }
        }
        return max;
    }
}
