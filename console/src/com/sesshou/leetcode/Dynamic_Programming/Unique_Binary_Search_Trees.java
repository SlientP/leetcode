package com.sesshou.leetcode.Dynamic_Programming;

import java.util.LinkedList;

/**
 * @author wp41128
 * @date 2020/6/16 15:41
 * @description：
 */
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < n+1 ; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }


    public class TreeNode {
        int val;
        Unique_Binary_Search_Trees_II.TreeNode left;
        Unique_Binary_Search_Trees_II.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Unique_Binary_Search_Trees_II.TreeNode left, Unique_Binary_Search_Trees_II.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
