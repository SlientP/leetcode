package com.newStart;

import java.util.HashMap;

public class Q142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pre=head.next;
        ListNode tail=head;
        while (pre!=tail){
            if(pre==null||pre.next==null){
                return null;
            }
            pre=pre.next.next;
            tail=tail.next;
        }
        //需要重新开始赋值...
        //头指针的i+C+k=2(i+k)=> i+k=C
        tail=head;
        pre=pre.next;
        while (pre!=tail){
            pre=pre.next;
            tail=tail.next;
        }
        return pre;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
