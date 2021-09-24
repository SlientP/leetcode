package com.newStart;

//Convert Sorted List to Binary Search Tree
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
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    ListNode globalHead;
    public TreeNode sortedListToBSTV2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }
    private TreeNode buildTree(int left ,int right){
        if(left>right) return null;
        int mid=(left+right+1)/2;
        TreeNode root=new TreeNode();
        root.left=buildTree(0,mid);
        root.val= globalHead.val;
        globalHead=globalHead.next;
        root.right=buildTree(mid+1,right);
        return root;
    }
    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class TreeNode {
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
