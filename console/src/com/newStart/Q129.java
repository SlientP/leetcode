package com.newStart;

public class Q129 {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return test(root,0);
    }
    private int test(TreeNode root,int temp){
        if(root.left==null&&root.right==null){
            return temp*10+root.val;
        }
        int val=root.val;
        int res=0;
        temp=temp*10+val;
        if(root.left!=null) res+=test(root.left,temp);
        if(root.right!=null) res+=test(root.right,temp);
        return res;
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
