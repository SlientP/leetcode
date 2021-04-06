package com.newStart;

public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newhead=head;
        ListNode tail=head;
        ListNode move=head.next;
        while (move!=null){
            if(head.val>=move.val){
                tail.next=move.next;
                move.next=newhead;
                newhead=move;
            }else if(tail.val<=move.val){
                tail=move;
            }else{
                ListNode insert=newhead;
                while (insert!=move&&insert.next.val<move.val) insert=insert.next;
                tail.next=move.next;
                ListNode temp=insert.next;
                insert.next=move;
                move.next=temp;
            }
            move=tail.next;
        }
        return newhead;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
