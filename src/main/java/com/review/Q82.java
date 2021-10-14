package com.review;

//82. Remove Duplicates from Sorted List ---Q83
//need focus
public class Q82 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode next=head.next;
        //如果头指针和下一个指针相等 则全部舍去 head=deleteDuplicates(next);
        if(head.val==next.val){
            while (next!=null&&head.val==next.val) next=next.next;
            head=deleteDuplicates(next);
        }else{
            head.next=deleteDuplicates(next);
        }
        return head;
    }
}
