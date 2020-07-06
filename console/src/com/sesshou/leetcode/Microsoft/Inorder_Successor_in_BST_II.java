package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/30 17:30
 * @description：二叉树的中继节点2（不访问值）
 */
public class Inorder_Successor_in_BST_II {
    public Node inorderSuccessor(Node node) {
        //case1 有右节点 先往右再往左
        if(node.right!=null){
            node=node.right;
            while (node!=null&&node.left!=null) node=node.left;
            return node;
        }
        //case2 没有右节点 先往上再尽可能往右
        while (node.parent!=null&&node==node.parent.right) node=node.parent;
        return node.parent;


    }
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
        Node(int val){

        }
    }
}
