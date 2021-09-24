package com.newStart;

public class Q114 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);TreeNode t2=new TreeNode(2);TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);TreeNode t5=new TreeNode(5);TreeNode t6=new TreeNode(6);
        t1.left=t2;t1.right=t5;t5.right=t6;t2.left=t3;t2.right=t4;
        Q114 test=new Q114();
        test.flatten(t1);
        System.out.println(1);
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        if(root.left==null&&root.right==null) return root;
        TreeNode temp=null;
        if(root.right!=null) temp=dfs(root.right);
        if(root.left!=null) root.right=dfs(root.left);
        return root;
    }
    static class TreeNode {
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
