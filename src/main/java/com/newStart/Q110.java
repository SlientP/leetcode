package com.newStart;

public class Q110 {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int L=height(root.left);
        int R=height(root.right);
        if(L==-1||R==-1||Math.abs(R-L)>1){
            return -1;
        }else {
            return Math.max(L,R)+1;
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
