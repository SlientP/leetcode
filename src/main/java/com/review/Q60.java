package com.review;

public class Q60 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode pre=head;
        int n=1;
        while(pre.next!=null){
            pre=pre.next;
            n++;
        }
        pre.next=head;
        ListNode newtail=head;
        for (int i = 0; i < n - k%n-1 ; i++) {
            newtail=newtail.next;
        }
        ListNode newhead=newtail.next;
        newtail.next=null;
        return newhead;
    }
}
