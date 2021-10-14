package com.review;

//98. Validate Binary Search Tree
//为什么使用Long.MAX_VALUE, Long.MIN_VALUE
//是因为如果树的节点值等于Integer的最大值的话或者最小值就会错判
public class Q98 {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return doValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean doValidBST(TreeNode root,long high,long low){
        if(root==null) return true;
        boolean flag=true;
        if(root.val>low&&root.val<high){
            if(root.left!=null){
                flag=flag&&doValidBST(root.left, root.val, low);
            }
            if(root.right!=null){
                flag=flag&&doValidBST(root.right, high, root.val);
            }
        }else return false; 
        return flag;
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
