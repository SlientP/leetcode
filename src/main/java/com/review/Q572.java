package com.review;

import java.util.ArrayList;
import java.util.List;

import com.Struct.TreeNode;

//572. Subtree of Another Tree
public class Q572 {
    private List<TreeNode> list=new ArrayList<>();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        searchNode(root, subRoot.val);
        boolean flag=false;
        for (TreeNode treeNode : list) {
            flag=flag||isSameTree(treeNode, subRoot);
        }
        return flag;
    }

    private void searchNode(TreeNode root,int val){
        if(root==null) return;
        if(root.val==val) list.add(root);
        searchNode(root.left, val);
        searchNode(root.right, val);
    }
    
    private boolean isSameTree(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1!=null&&node2!=null&&node1.val==node2.val) return isSameTree(node1.left, node2.left)&&isSameTree(node1.right, node2.right);
        return false;
    }
}
