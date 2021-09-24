package com.newStart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q105 {
    public static void main(String[] args) {
        Q105 test=new Q105();
        int[] preorder=new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode node=test.buildTree(preorder,inorder);
        System.out.println(1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return  buildTreeV2(preorder,inorder,indexMap);

    }
    public TreeNode buildTreeV2(int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        int pre_len=preorder.length;
        int in_len=inorder.length;
        if(pre_len==0||in_len==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        int index=0;
        for (int i = 0; i < in_len; i++) {
            if(inorder[i]==preorder[0]) {index=i;break;}
        }
        root.left=buildTreeV2(Arrays.copyOfRange(preorder,1,index+1),
                Arrays.copyOfRange(inorder,0,index),map);
        if(index+1==in_len) root.right=null;
        else root.right=buildTreeV2(Arrays.copyOfRange(preorder,index+1,pre_len),
                Arrays.copyOfRange(inorder,index+1,in_len),map);
        return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
