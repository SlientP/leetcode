package com.review;

import java.util.*;
import com.Struct.*;

//Construct Binary Tree from Inorder and Postorder Traversal --Q105
//中序和后序构造二叉树
public class Q106 {
    public static void main(String[] args) {
        TreeNode t9=new TreeNode(9);TreeNode t3=new TreeNode(3);TreeNode t15=new TreeNode(15);
        TreeNode t20=new TreeNode(20);TreeNode t7=new TreeNode(7);
        t3.left=t9;t3.right=t20;t20.left=t15;t20.right=t7;
        Q106 test=new Q106();
        int[] inorder=new int[]{9,3,15,20,7};
        int[] postorder=new int[]{9,15,7,20,3};
        test.buildTree(inorder, postorder);
    }
    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    private int post_root;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n=postorder.length;
        post_root=postorder.length-1;
        return  myBuildTree(inorder,postorder,0,n-1);
    }

    public TreeNode myBuildTree(int[] postorder, int[] inorder,int left, int right) {
        if (left > right) {
            return null;
        }
        
        // 后序遍历中的最后节点就是根节点
        int postorder_root = post_root;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(postorder[postorder_root]);
        post_root--;
        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // 递归地构造右左子树，并连接到根节点
        // 后序遍历中 先访问了左节点在访问了右节点 如果从尾部开访问就是先访问根节点->右节点->左节点
        // 所以需要先构造右节点
        root.right = myBuildTree(postorder, inorder, inorder_root + 1, right);
        root.left = myBuildTree(postorder, inorder, left,inorder_root-1);
        return root;
    }
}
