package com.review;



import com.Struct.TreeNode;

//543. Diameter of Binary Tree
public class Q543 {

    private int result=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    private int dfs(TreeNode node){
        if(node==null) return 0;
        int L=0;int R=0;
        if(node.left!=null)  L=dfs(node.left);
        if(node.right!=null)  R=dfs(node.right);
        result=Math.max(result, R+L+1);
        return Math.max(L, R)+1;
    }
}
