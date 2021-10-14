package com.review;

import com.Struct.*;
import java.util.*;

import javax.swing.event.RowSorterListener;

//114. Flatten Binary Tree to Linked List
public class Q114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    //只使用O（1）的空间
    public void flattenV2(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode next=curr.left;
                TreeNode right=next;
                while(right.right!=null) right=right.right;
                right.right=curr.right;
                curr.left=null;
                curr.right=next;
            }
            curr=curr.right;
        }
    }
}
