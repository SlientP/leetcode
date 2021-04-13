package com.newStart2;

import java.util.Stack;

public class Q230 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        t2.left=t1;t3.left=t2;t3.right=t4;t5.left=t3;t5.right=t6;
        Q230 test=new Q230();
        test.kthSmallest(t5,3);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        DFS(root,stack,k);
        return stack.pop().val;
    }

    private void DFS(TreeNode root, Stack<TreeNode> stack,int k){
        if(k==0) return;
        if(root==null) return;
        if(k>0&&root.left!=null) DFS(root.left,stack,k);
        if(k>0) stack.push(root);
        k--;
        if(k>0&&root.right!=null) DFS(root.right,stack,k);
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
