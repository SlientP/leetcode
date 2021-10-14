package com.review;

//21. Merge Two Sorted Lists
public class Q21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode result=head;
        while (l1!=null||l2!=null){
            if(l1==null){
                head.next=new ListNode(l2.val);
                l2=l2==null?null:l2.next;
            }else if(l2==null){
                head.next=new ListNode(l1.val);
                l1=l1==null?null:l1.next;
            }else{
                if(l1.val>l2.val) {
                    head.next = new ListNode(l2.val);
                    l2=l2==null?null:l2.next;
                }
                else {
                    head.next = new ListNode(l1.val);
                    l1=l1==null?null:l1.next;
                }
            }
           head=head.next;
        }
        return result.next;
    }
}
