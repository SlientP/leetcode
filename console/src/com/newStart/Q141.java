package com.newStart;

public class Q141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pre=head.next;
        ListNode tail=head;
        while (pre!=tail){
            if(pre==null||pre.next==null){
                return false;
            }
            pre=pre.next.next;
            tail=tail.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
