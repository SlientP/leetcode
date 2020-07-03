package com.sesshou.leetcode.Dynamic_Programming;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/5/13 10:02
 * @description：
 */
public class Palindrome_Partitioning_III {

    public static void main(String[] args) {
        Palindrome_Partitioning_III test=new Palindrome_Partitioning_III();
        System.out.println(test.palindromePartition("abc",2));
    }

    int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost=new int[n][n];
        for (int span = 2; span <= n; ++span) {
            for (int i = 0; i <= n - span; ++i) {
                int j = i + span - 1;
                cost[i][j] = cost[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }

        int[][] f =new int[n+1][k+1];
        for (int i = 0; i < n+1 ; i++) {
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }

        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(k, i); ++j) {
                if (j == 1) {
                    f[i][j] = cost[0][i - 1];
                }
                else {
                    for (int i0 = j - 1; i0 < i; ++i0) {
                        f[i][j] = Math.min(f[i][j], f[i0][j - 1] + cost[i0][i - 1]);
                    }
                }
            }
        }

        return f[n][k];

    }

}
