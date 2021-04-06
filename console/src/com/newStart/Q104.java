package com.newStart;

public class Q104 {
    public int maxDepth(TreeNode root) {
        int max=0;
        if(root==null) return max;
        max=Math.max(dfs(root.left,1),dfs(root.right,1));
        return max;
    }
    private int dfs(TreeNode node,int n){
        if(node==null) return n;
        else if(node.left!=null&&node.right!=null) return Math.max(dfs(node.left,n+1),dfs(node.right,n+1));
        else if(node.right!=null) return dfs(node.right,n+1);
        else return dfs(node.left,n+1);
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
