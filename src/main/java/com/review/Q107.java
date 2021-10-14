package com.review;

import java.util.*;
import com.Struct.*;
//107. Binary Tree Level Order Traversal II --Q102
//与102的差别在于是自底向上
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> temp=new ArrayDeque<>();
        temp.offer(root);
        while (!temp.isEmpty()){
            List<Integer> item=new ArrayList<>();
            int count=temp.size();
            while (!temp.isEmpty()&&count>0){
                TreeNode t=temp.poll();
                item.add(t.val);
                count--;
                if(t.left!=null) temp.offer(t.left);
                if(t.right!=null) temp.offer(t.right);
            }
            res.add(0,item);
        }
        return res;
    }
}
