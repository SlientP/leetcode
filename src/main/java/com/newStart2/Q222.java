package com.newStart2;

public class Q222 {
    private int count=0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        else {
            count++;
            dfs(root.left);
            dfs(root.right);
        }

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
}
