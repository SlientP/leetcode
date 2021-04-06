package com.newStart2;

public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        while (head!=null&&head.val==val) head=head.next;
        ListNode pre=head;
        ListNode next=head==null?head:head.next;
        while (pre!=null&&next!=null){
            while (next!=null&&next.val==val) next=next.next;
            pre.next=next.next;
            pre=pre.next;
            next=pre==null?pre:pre.next;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
