package com.newStart2;

import com.sesshou.leetcode.Reverse_Linked_List;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            //保留下一个指针
            ListNode temp=curr.next;
            //断链+指链
            curr.next=prev;
            //移动指针
            prev=curr;
            //下一个元素
            curr=temp;
        }
        return prev;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
