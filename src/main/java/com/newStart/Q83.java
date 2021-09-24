package com.newStart;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=head;
        ListNode next=head.next;
        while (next!=null){
            if(next!=null&&next.val==pre.val){
                next=next.next;
            }else{
                pre.next=next;
                pre=next;
                next=next.next;
            }
        }
        pre.next=next;
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



