package com.sesshou.leetcode.Daily;

import java.util.Queue;

/**
 * @author wp41128
 * @date 2020/7/7 7:27
 * @description：路径和
 */
public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val==sum&&root.left==null&&root.right==null) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
