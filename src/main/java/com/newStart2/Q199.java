package com.newStart2;

import java.util.*;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        TreeNode node=null;
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            if(tree!=null) {
                node = tree;
                if(tree.left!=null)
                    queue.offer(tree.left);
                if(tree.right!=null)
                    queue.offer(tree.right);
            }
            else {
                res.add(node.val);
                if(queue.size()>0) {
                    queue.offer(null);
                }
            }


        }
        return res;

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
