package com.newStart;

//Minimum Depth of Binary Tree
//节点遍历必须到达叶子节点的
//可能有左右叶子节点不都存在
public class Q111 {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.right!=null&&root.left==null){
            return 1+minDepth(root.right);
        }else if(root.left!=null&&root.right==null){
            return 1+minDepth(root.left);
        } else{
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
