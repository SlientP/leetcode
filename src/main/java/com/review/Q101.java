package com.review;

import com.Struct.TreeNode;

//101. Symmetric Tree
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
         return doValidSymmetric(root.left,root.right);
    }

    private boolean doValidSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left!=null&&right!=null&&left.val==right.val) 
        return doValidSymmetric(left.right, right.left)&&doValidSymmetric(left.left, right.right);
        else return false;
    }
}
