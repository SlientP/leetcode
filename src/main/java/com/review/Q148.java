package com.review;

import com.Struct.*;
//148. Sort List
//需要使用O（Log(n)）
public class Q148 {
    public ListNode sortList(ListNode head) {
        return new ListNode();
    }

    private ListNode sort(ListNode start,ListNode end){
        if(start==end) return  start;
        ListNode slow=start;
        ListNode fast=start;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l1=sort(slow.next, end);
        slow.next=null;
        ListNode l2=sort(start, slow);

        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null||l2==null) return l1==null?l2:l1;
        
        if(l1.val<l2.val) {
            l1.next=merge(l1.next, l2);
            return l1;
        }else{
            l2.next=merge(l1, l2.next);
            return l2;
        }
        
    }
}
