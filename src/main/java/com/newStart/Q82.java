package com.newStart;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode next=head.next;
        if(head.val==next.val){
            while (next!=null&&head.val==next.val) next=next.next;
            head=deleteDuplicates(next);
        }else{
            head.next=deleteDuplicates(next);
        }
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
