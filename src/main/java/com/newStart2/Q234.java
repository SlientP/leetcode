package com.newStart2;

import java.util.List;

public class Q234 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(1);
        //ListNode n4=new ListNode(1);
        n1.next=n2;n2.next=n3;//.next=n4;
        Q234 test=new Q234();
        test.isPalindrome(n1);
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //1,0,1 必须要next 不然可能从中心节点开始反转
        ListNode second=reserve(slow.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = second;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    private ListNode reserve(ListNode start){
        ListNode prev=null;
        ListNode curr=start;
        while (curr!=null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
