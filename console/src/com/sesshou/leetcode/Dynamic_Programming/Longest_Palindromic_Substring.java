package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/6/24 11:09
 * @description：最长回文字符串
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Longest_Palindromic_Substring test=new Longest_Palindromic_Substring();
        System.out.println("babad".substring(0,5));
        System.out.println(test.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len==1) return s;
        boolean[][] dp=new boolean[len+1][len+1];
        String result="";
        for (int j = 0; j < len + 1; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j || i + 1 == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j-1) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && result.length() < j - i) result = s.substring(i, j);
            }
        }
        return result;
    }
}
