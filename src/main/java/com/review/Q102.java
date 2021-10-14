package com.review;

import java.util.*;
import com.Struct.*;

//102. Binary Tree Level Order Traversal --Q107
//层序遍历 自顶向下
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(item);
        }
        return res;
    }
}
