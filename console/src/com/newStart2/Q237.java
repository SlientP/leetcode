package com.newStart2;

public class Q237 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(5);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(9);
        n1.next=n2;n2.next=n3;n3.next=n4;
        Q237 test=new Q237();
        test.deleteNode(n2);
    }
    //can not get the pre node
    public void deleteNode(ListNode node) {
        ListNode curr=node.next;
        ListNode pre=node;
        while (curr!=null&&curr.next!=null){
            pre.val=curr.val;
            pre=pre.next;
            curr=curr.next;
        }
        pre.val=curr.val;
        pre.next=null;
    }
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
}
