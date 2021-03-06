package com.newStart;

public class Q61 {
    public static void main(String[] args) {
        Q61 test=new Q61();
//        ListNode l0=new ListNode(1);
//        ListNode l1=new ListNode(2);
//        ListNode l2=new ListNode(3);
//        ListNode l3=new ListNode(4);
//        ListNode l4=new ListNode(5);
//        l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;
        ListNode l0=new ListNode(0);
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        l0.next=l1;l1.next=l2;
        test.rotateRight(l0,4);
        System.out.println("123");
    }
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring(环)
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

