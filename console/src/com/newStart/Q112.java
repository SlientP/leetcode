package com.newStart;

public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val==sum&&root.left==null&&root.right==null) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
