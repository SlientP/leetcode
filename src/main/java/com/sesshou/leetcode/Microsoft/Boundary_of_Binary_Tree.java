package com.sesshou.leetcode.Microsoft;

import com.sesshou.leetcode.Array.Trapping_Rain_Water;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wp41128
 * @date 2020/6/19 10:09
 * @description：二叉树的边界
 */
public class Boundary_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        node2.left=node3;
        node2.right=node4;
        node1.right=node2;
        Boundary_of_Binary_Tree test=new Boundary_of_Binary_Tree();
        List<Integer> res=test.boundaryOfBinaryTree(node1);
        System.out.println(1);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        if(!isLeaf(root)) res.add(root.val);
        //添加左分支节点
        TreeNode left=root.left;
        while (left!=null){
            if(!isLeaf(left)){
                res.add(left.val);
            }
            if(left.left!=null){
                left=left.left;
            }else{
                left=left.right;
            }
        }
        addLeaves(res,root);
        Stack<Integer> rights=new Stack<Integer>();
        TreeNode right=root.right;
        while (right!=null){
            if(!isLeaf(right)){
                rights.push(right.val);
            }
            if(right.right!=null){
                right=right.right;
            }else{
                right=right.left;
            }
        }
        while (!rights.empty()){
            res.add(rights.pop());
        }
        return res;
    }
    //添加叶子节点
    private void addLeaves(List<Integer> list,TreeNode root){
        if(isLeaf(root)){
            list.add(root.val);
        }else{
            if(root.left!=null){
                addLeaves(list,root.left);
            }
            if(root.right!=null){
                addLeaves(list,root.right);
            }
        }
    }
    private boolean isLeaf(TreeNode node){
        return node.left==null&&node.right==null;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
