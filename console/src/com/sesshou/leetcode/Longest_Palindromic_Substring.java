package com.sesshou.leetcode;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/2/28 11:43
 * @description：
 */
public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        Longest_Palindromic_Substring test=new Longest_Palindromic_Substring();
        System.out.println(test.Palindromic("abbc"));
    }

    public String Palindromic(String s) {
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
