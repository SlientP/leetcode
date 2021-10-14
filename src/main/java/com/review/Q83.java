package com.review;

//83. Remove Duplicates from Sorted List ---Q82

public class Q83 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=head;
        ListNode next=head.next;
        while (next!=null){
            if(next.val==pre.val){
                next=next.next;
            }else{
                pre.next=next;
                pre=next;
                next=next.next;
            }
        }
        //next 为null 需要一个尾结点
        pre.next=next;
        return head;
    }
}
