package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/30 15:22
 * @description：二叉查找树中第一个
 */
public class Inorder_Successor_in_BST {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        t2.left=t1;
        t2.right=t3;
        t4.left=t2;
        t4.right=t6;
        t6.left=t5;
        t6.right=t7;
        Inorder_Successor_in_BST test=new Inorder_Successor_in_BST();
        System.out.println(test.inorderSuccessor(t4,t2).val);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p==null||root==null){
            return null;
        }
        if(root.val<=p.val){//当前和左边都不可能>p
            return inorderSuccessor(root.right,p);
        }
        //root>p
        TreeNode res1=inorderSuccessor(root.left,p);
        if(res1!=null){
            return res1;
        }else{
            return root;
        }
    }
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int value){
            this.val=value;
            this.left=null;
            this.right=null;
        }
    }
}
