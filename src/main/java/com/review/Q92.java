package com.review;


//92. Reverse Linked List II --Q206
public class Q92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null) return head;
        ListNode pre=null;
        ListNode curr=head;
        while(m>1){
            pre=curr;
            curr=curr.next;
            m--;
            n--;
        }
        //记录断链开始的起始位置
        //为了最后连接头尾
        ListNode ppre=pre;
        ListNode tail=curr;
        ListNode temp=null;
        while(n>0){
            temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
            n--;
        }
        //不为null的情况 中间断链起始位置的下一个是当前的pre
        if(ppre!=null){
            ppre.next=pre;
        }else{
            //如果为null 表示从起始位置开始反转
            head=pre;
        }
        tail.next=curr;
        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
