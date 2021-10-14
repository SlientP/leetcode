package com.review;

//19. Remove Nth Node From End of List
//Follow up: Could you do this in one pass? 只能遍历一次
//【1】，1的情况需要多去考虑下
public class Q19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(0,head);
        ListNode curr=pre;
        ListNode tail=head;
        while(n>0){
            tail=tail.next;
            n--;
        }
        while(tail!=null){
            tail=tail.next;
            curr=curr.next;
        }
        curr.next=curr.next==null?null:curr.next.next;
        return pre.next;
    }
}
