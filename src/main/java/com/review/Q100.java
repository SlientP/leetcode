package com.review;

import com.Struct.TreeNode;

//100. Same Tree
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else if(p==null&&q==null){
            return true;
        }
        return false;
    }
}
