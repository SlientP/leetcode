package com.review;

import com.Struct.*;

//112. Path Sum
//一定要到叶子结点
public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
    
}
