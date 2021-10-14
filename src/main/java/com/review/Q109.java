package com.review;

import com.Struct.*;
//109. Convert Sorted List to Binary Search Tree
//为了转化成平衡二叉树 需要对head进行二分 以mid作为根节点 依次类推下去
public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode left,ListNode right){
        if(left==right) return null;
        ListNode mid=findmid(left,right);
        TreeNode root=new TreeNode(mid.val);
        root.left=buildTree(left,mid);
        root.right=buildTree(mid.next,right);
        return root;
    }

    private ListNode findmid(ListNode start,ListNode end){
        ListNode fast=start;
        ListNode slow=start;
        while (fast!=end&&fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
