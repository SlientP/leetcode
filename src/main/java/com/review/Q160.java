package com.review;

import com.Struct.*;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        //不能使用equals 因为如果使用equals headA就不为空
        //但是while的结束条件就是HeadA和HeadB都为null
        // while(!headA.equals(headB)){
        //     headA=headA.next==null?B:headA.next;
        //     headB=headB.next==null?A:headB.next;
        // }
        while(headA!=headB){
            headA=headA==null?B:headA.next;
            headB=headB==null?A:headB.next;
        }
        return headA;
    }
}
