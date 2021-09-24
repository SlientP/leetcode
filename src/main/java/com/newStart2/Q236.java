package com.newStart2;

public class Q236 {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }

    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return false;
        boolean lhas=dfs(root.left,p,q);
        boolean rhas=dfs(root.right,p,q);
        if(lhas&&rhas||((root.val==p.val||root.val==q.val)&&(lhas||rhas))){
            ans=root;
        }
        return lhas||rhas||root.val== q.val||root.val==p.val;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
