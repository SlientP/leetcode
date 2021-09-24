package com.newStart;

public class Q98 {
    public static void main(String[] args) {
        Q98 test=new Q98();
        TreeNode root=new TreeNode(2);
        TreeNode left=new TreeNode(1);
        TreeNode right=new TreeNode(3);
        root.left=left;root.right=right;
        System.out.println(test.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
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
