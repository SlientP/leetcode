package com.microsoftInterview;

import java.util.HashMap;

public class BuildTree {
    //需要定义为全局变量 因为无论左还是右子树构建以后都是要把节点减1的
    private int rootindex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode res=new TreeNode();
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        rootindex=postorder.length-1;
        res=buildMyTree(inorder,postorder,map,0,inorder.length-1);
        return res;
    }

    public TreeNode buildMyTree(int[] in,int[] post,HashMap<Integer,Integer> map,int i,int j){
        if(i>j) return null;
        TreeNode node=new TreeNode(post[rootindex]);
        int in_index=map.get(post[rootindex]);
        rootindex--;
        node.right=buildMyTree(in,post,map,in_index+1,j);
        node.left=buildMyTree(in,post,map,i,in_index-1);
        return node;
    }
    //[9,3,15,20,7]
    //[9,15,7,20,3]
    //left 9 right 9
    public class TreeNode {
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
