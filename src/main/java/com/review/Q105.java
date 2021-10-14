package com.review;

import java.util.*;
import com.Struct.*;

//105. Construct Binary Tree from Preorder and Inorder Traversal --Q016
//前序和中序遍历构造二叉树
public class Q105 {
    public static void main(String[] args) {
        Q105 test=new Q105();
        int[] preorder=new int[]{1,2,3};
        int[] inorder=new int[]{3,2,1};
        test.buildTree(preorder, inorder);
    }
    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n=preorder.length;
        //return  buildTreeV2(preorder,inorder,indexMap);
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTreeV2(int[] pre,int[] inorder,Map<Integer,Integer> indexMap){
        int pre_len=pre.length;
        int in_len=pre.length;
        if(pre_len==0||in_len==0) return null;
        TreeNode root=new TreeNode(pre[0]);
        int index=indexMap.get(pre[0]);
        root.left=buildTreeV2(Arrays.copyOfRange(pre, 1, index+1), Arrays.copyOfRange(inorder, 0,index),indexMap);
        if(index+1==in_len) root.right=null;
        else root.right=buildTreeV2(Arrays.copyOfRange(pre, index+1,pre_len ), Arrays.copyOfRange(inorder, index+1, in_len), indexMap);
        return root;
    }
    //这个和上面copy的区别在于 copy的时候把之前的元素都剔除掉了 所以可以使用index进行传递
    //下面这个是没有进行copy操作还保留了之前的元素
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left+size_left_subtree, inorder_left, inorder_root);
        if(inorder_root+1==inorder_right) root.right=null;
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        else root.right = myBuildTree(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
