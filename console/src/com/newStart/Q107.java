package com.newStart;

import java.util.*;

public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
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
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
