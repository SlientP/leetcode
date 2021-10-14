package com.review;

//24. Swap Nodes in Pairs
public class Q24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode(0,head);
        if(head==null||head.next==null) return head;
        ListNode pre=result;
       
        while(head!=null&&head.next!=null){
            ListNode l1=head;
            ListNode l2=head.next;

            pre.next=l2;
            l1.next=l2.next;
            l2.next=l1;

            head=l1.next;
            pre=l1;
        }
        return result.next;
    }
}
