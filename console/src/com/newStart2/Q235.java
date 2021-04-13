package com.newStart2;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcm(root,p,q);
    }

    private TreeNode lcm(TreeNode root,TreeNode q,TreeNode p){
        if((root.val-q.val)*(root.val-p.val)<0){
            return root;
        }else if(root.val> q.val&&root.val>q.val){
            return lcm(root.left,q,p);
        }else  return lcm(root.right,q,p);
    }
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
