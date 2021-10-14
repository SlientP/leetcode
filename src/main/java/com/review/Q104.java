package com.review;

import com.Struct.TreeNode;
//104. Maximum Depth of Binary Tree
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
}
