package com.newStart;

import java.util.List;

//Swap Nodes in Pairs

public class Q24 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;l2.next=l3;l3.next=l4;
        Q24 test=new Q24();
        ListNode result=test.swapPairs(l1);
        System.out.println("123");
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode pre=result;
        while (head!=null&&head.next!=null){
            ListNode l1=head;
            ListNode l2=head.next;

            pre.next=l2;
            l1.next=l2.next;
            l2.next=l1;

            pre=l1;
            head=l1.next;
        }
        return result.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
