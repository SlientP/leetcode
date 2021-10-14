package com.review;

import java.util.ArrayList;
import java.util.List;

//96. Unique Binary Search Trees --Q95
//需要返回所有的可能性
public class Q96 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<>();
        res= dfs(1, n);
        return res;
    }

    private List<TreeNode> dfs(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left=dfs(start,i-1 );
            List<TreeNode> right=dfs(i+1,end);
            for (TreeNode treeNode : left) {
                for (TreeNode treeNode2 : right) {
                    TreeNode node=new TreeNode(i);
                    node.left=treeNode;
                    node.right=treeNode2;
                    res.add(node);
                }
            }
        }
        return res;
    }
    public static class TreeNode {
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
