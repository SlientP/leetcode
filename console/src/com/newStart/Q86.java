package com.newStart;

//采用2个指针，预先定义插入的头部尾部
public class Q86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode n1=new ListNode(0);
        ListNode n2=new ListNode(0);
        ListNode node1 = n1;
        ListNode node2 = n2;
        while (head!=null){
            if(head.val<x){
                n1.next=head;
                n1=n1.next;
                head=head.next;
                n1.next=null;
            }else{
                n2.next=head;
                n2=n2.next;
                head=head.next;
                n2.next=null;
            }
        }
        n1.next=node2.next;
        return node1.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
