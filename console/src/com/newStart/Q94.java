package com.newStart;

import java.util.ArrayList;
import java.util.List;

public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }

    public void dfs(TreeNode root,List<Integer> res){
        if(root==null) return;
        if(root.left!=null){
            dfs(root.left,res);
        }
        res.add(root.val);
        if(root.right!=null){
            dfs(root.right,res);
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
