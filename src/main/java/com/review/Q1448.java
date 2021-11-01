package com.review;

import com.Struct.*;

//1448. Count Good Nodes in Binary Tree
public class Q1448 {
    private int count=0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode node,int max){
        if(node!=null){
            if(node.val>=max) {
                count++;
                dfs(node.left, node.val);
                dfs(node.right, node.val);
            }else{
                dfs(node.left, max);
                dfs(node.right, max);
            }
        }
    }
}
