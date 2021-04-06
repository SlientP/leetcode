package com.newStart;

import java.util.Stack;

public class Q143 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
        Q143 test=new Q143();
        test.reorderList(l1);
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode pre=head;
        while (pre!=null){
            stack.push(pre);
            pre=pre.next;
        }
        int i=1;
        pre=head;
        int len=stack.size();
        while (len/2+1>=i){
            ListNode item=stack.pop();
            ListNode temp=pre.next;
            pre.next=item;
            item.next=temp;
            pre=temp;
            i=i+2;
        }
        pre.next=null;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
